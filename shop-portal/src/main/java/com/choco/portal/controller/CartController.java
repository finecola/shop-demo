package com.choco.portal.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.rpc.service.CartService;
import com.choco.rpc.vo.CartResult;
import com.choco.rpc.vo.CartVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by choco on 2021/1/7 16:24
 */
@Controller
@RequestMapping("cart")
public class CartController {
    @Reference(interfaceClass = CartService.class)
    private CartService cartService;

    /**
     * 添加购物车
     * @param cartVo
     * @param request
     * @return
     */
    @PostMapping("add")
    public BaseResult addCart(CartVo cartVo, HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("user");
        if (admin!=null && admin.getAdminId()!=null){
            return cartService.addCart(cartVo, admin);
        }
        return BaseResult.error();
    }

    /**
     * 查询购物车的数量
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("getCartNum")
    public Integer getCart(HttpServletRequest request){
        Admin user = (Admin) request.getSession().getAttribute("user");
        Integer cartNums = cartService.getCartNums(user);
        if (cartNums!=null){
            return cartNums;
        }
        return 0;
    }

    @GetMapping("list")
    public String getCartList(Admin admin, Model model){
        CartResult cartList = cartService.getCartList(admin);
        if (cartList!=null){
            model.addAttribute("cartList",cartList);
            return "cart/cartList";
        }
        return null;
    }
}
