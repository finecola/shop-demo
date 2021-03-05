package com.choco.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by choco on 2021/1/11 16:13
 */
@Controller
public class OrderController {

    /**
     * 跳转预订单
     *
     * @return
     */
    @RequestMapping("preOrder")
//    @ResponseBody
    public String toOrder(HttpServletRequest request) {
        ServletContext servletContext = request.getSession().getServletContext();
        String orderUrl = (String) servletContext.getAttribute("orderUrl");
        //重定向
        return "redirect:" + orderUrl + "order/preOrder";
    }
}
