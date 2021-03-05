package com.choco.order.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by choco on 2021/1/11 22:54
 */
@Controller
@RequestMapping("user")
public class UserController {

    @ResponseBody
    @GetMapping("logout")
    public String logout(HttpServletRequest request){
        return "redirect:"+request.getSession().getServletContext().getAttribute("portalUrl")+"user/logout";
    }
}
