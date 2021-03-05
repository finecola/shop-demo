package com.choco.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by choco on 2020/12/28 15:13
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String login() {
        return "index";
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("index")
    public String login1() {
        return "index";
    }

    /**
     * 欢迎页
     * @return
     */
    @RequestMapping("welcome")
    public String welcome() {
        return "welcome";
    }

    /**
     * 精确匹配登录
     * @param redirectUrl
     * @param model
     * @return
     */
    @PostMapping("login")
    public String login(String redirectUrl, Model model){
        model.addAttribute("redirectUrl",redirectUrl);
        return "login";
    }
}
