package com.choco.manager.interceptor;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.entity.Admin;
import com.choco.common.utils.CookieUtil;
import com.choco.common.utils.JsonUtil;
import com.choco.sso.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * Created by choco on 2021/1/6 11:51
 */
@Component
public class ManagerLoginInterceptor implements HandlerInterceptor {
    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Value("${user.ticket}")
    private String userTicket;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ticket = CookieUtil.getCookieValue(request, "userTicket");
        if (!StringUtils.isEmpty(ticket)) {
            //这一步就是验证
            Admin admin = ssoService.validate(ticket);
            request.getSession().setAttribute("user", admin);

            //重新设置redis的失效时间
            ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(userTicket+":"+ticket, JsonUtil.object2JsonStr(admin),30L, TimeUnit.MINUTES);
            return true;
        }
        //如何ticket不存在,则重定向
        response.sendRedirect(request.getContextPath()+"/user/toLogin");
        return false;
    }

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
