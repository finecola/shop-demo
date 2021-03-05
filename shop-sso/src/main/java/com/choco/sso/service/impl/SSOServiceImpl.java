package com.choco.sso.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.choco.common.entity.Admin;
import com.choco.common.entity.AdminExample;
import com.choco.common.utils.JsonUtil;
import com.choco.common.utils.Md5Util;
import com.choco.common.utils.UUIDUtil;
import com.choco.sso.mapper.AdminMapper;
import com.choco.sso.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by choco on 2021/1/5 22:29
 */
@Service(interfaceClass = SSOService.class)
@Component
public class SSOServiceImpl implements SSOService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Value("${user.ticket}")
    private String userTicket;



    @Override
    public String login(Admin admin) {
        //判断用户名是否为空
        if (StringUtils.isEmpty(admin.getUserName().trim())) {
            return null;
        }
        //判断密码是否为空
        if (StringUtils.isEmpty(admin.getPassword().trim())) {
            return null;
        }

        //验证用户名
        AdminExample example = new AdminExample();
        example.createCriteria().andUserNameEqualTo(admin.getUserName());

        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size() == 0 || admins.size() > 1) {
            return "用户名或密码错误";
        }
        //根据用户名从数据库获取用户
        Admin user = admins.get(0);
        String encodingPassword = Md5Util.getMd5WithSalt(admin.getPassword(), user.getEcSalt());
        if (!user.getPassword().equals(encodingPassword)) {
            System.out.println("密码错误");
            return null;
        }

        //获取ticket
        String ticket = UUIDUtil.getUUID();

        //把user存入redis,有效时间30分钟
        redisTemplate.opsForValue().set(userTicket + ":" + ticket, JsonUtil.object2JsonStr(user), 30L, TimeUnit.MINUTES);

        return ticket;
    }

    @Override
    public Admin validate(String ticket) {
        if (StringUtils.isEmpty(ticket)) {
            System.out.println("ticket不存在");
            return null;
        }

        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();


        //获取admin用户
        String adminJson = valueOperations.get(userTicket + ":" + ticket);

        //判断返admin用户是否为空
        if (StringUtils.isEmpty(adminJson)) {
            System.out.println("用户信息不存在");
            return null;
        }
        //转换为admin格式返回
        return JsonUtil.jsonStr2Object(adminJson, Admin.class);
    }

    @Override
    public void logout(String ticket) {
        //删除redis key
        redisTemplate.delete(userTicket + ":" + ticket);
    }
}
