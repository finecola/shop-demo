package com.choco.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.entity.Admin;
import com.choco.rpc.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by choco on 2021/1/11 17:17
 */
@Controller
@RequestMapping("cart")
public class CartController {
    @Reference(interfaceClass = CartService.class)
    private CartService cartService;

    /**
     * 返回购物车数量
     * @param model
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("cartNum")
    public Integer getCartNum(Model model, HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("user");
        return cartService.getCartNums(admin);
    }
}
