package com.choco.rpc.service;

import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.rpc.vo.CartResult;
import com.choco.rpc.vo.CartVo;

/**
 * Created by choco on 2021/1/7 14:11
 */
public interface CartService {
    /**
     * 添加购物车
     * @param cartVo
     * @param admin
     * @return
     */
    BaseResult addCart(CartVo cartVo, Admin admin);

    /**
     * 查询购物车数量
     * @param admin
     * @return
     */
    Integer getCartNums(Admin admin);

    /**
     * 获取购物车list<cartVo>,计算总价
     */
    CartResult getCartList(Admin admin);

    /**
     * 清除购物车
     * @param admin
     * @return
     */
    BaseResult clearCart(Admin admin);
}
