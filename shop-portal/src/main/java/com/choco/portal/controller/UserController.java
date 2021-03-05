package com.choco.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.entity.Admin;
import com.choco.common.entity.AdminWithBLOBs;
import com.choco.common.result.BaseResult;
import com.choco.portal.service.impl.CookieServiceImpl;
import com.choco.portal.service.impl.UserServiceImpl;
import com.choco.sso.service.SSOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by choco on 2021/1/6 11:28
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Reference(interfaceClass = SSOService.class)
    private SSOService ssoService;
    @Autowired
    private CookieServiceImpl cookieService;
    @Autowired
    private UserServiceImpl userService;

    /**
     * 用户登录
     *
     * @param admin
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping("login")
    public BaseResult login(Admin admin, HttpServletRequest request, HttpServletResponse response) {
        String ticket = ssoService.login(admin);
        if (!StringUtils.isEmpty(ticket)) {
            //设置cookie
            boolean b = cookieService.setCookie(request, response, ticket);
            //把用户信息存入session
            request.getSession().setAttribute("user", admin);
            //返回登录结果
            return b ? BaseResult.success() : BaseResult.error();
        }
        return BaseResult.error();
    }

    /**
     * 跳转到登录界面
     * @return
     */
    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    /**
     * 登出,返回登录界面
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        //获取ticket
        String ticket = cookieService.getCookie(request);
        System.out.println("ticket"+ticket);
        //清除redis缓存
        try{
            ssoService.logout(ticket);
            //清除session
            request.getSession().removeAttribute("user");
            //清除cookie
            cookieService.deleteCookie(request, response);
            return "login";
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用户注册
     * @param admin
     * @return
     */
    @ResponseBody
    @PostMapping("register")
    public BaseResult register(AdminWithBLOBs admin){
        BaseResult baseResult = userService.userSave(admin);
        //smsService.send(phoneNum)
        return baseResult;
    }
}
