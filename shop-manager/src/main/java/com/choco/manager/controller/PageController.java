package com.choco.manager.controller;

import org.springframework.stereotype.Controller;
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

    @RequestMapping("/index")
    public String login1() {
        return "index";
    }

    @RequestMapping("welcome")
    public String welcome(){
        return "welcome";
    }
}
