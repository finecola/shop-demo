package com.choco.portal.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.choco.common.entity.AdminWithBLOBs;
import com.choco.common.result.BaseResult;
import com.choco.common.result.RandomUtil;
import com.choco.common.utils.Md5Util;
import com.choco.portal.mapper.AdminMapper;
import com.choco.portal.service.UserService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by choco on 2021/1/12 13:15
 */
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public BaseResult userSave(AdminWithBLOBs admin) {
        //获取盐
        String salt = RandomUtil.getRandom2(4);
        admin.setEcSalt(salt);

        //获取随机盐加密密码
        String password = Md5Util.getMd5WithSalt(admin.getPassword(), salt);
        admin.setPassword(password);

        //设置注册时间
        admin.setAddTime((int) LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")));
        //保存到数据库
        int result = adminMapper.insertSelective(admin);
        if (result > 0) {
            //发送用户的手机号到交换机
            rabbitTemplate.convertAndSend("smsExchange", "register.msg", admin.getEmail());
            System.out.println("send----->" + admin.getEmail());
            return BaseResult.success();
        }
        return BaseResult.error();
    }
}
