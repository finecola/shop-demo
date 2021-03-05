package com.choco.order.service;

import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.order.entity.Order;
import com.choco.rpc.vo.CartResult;

/**
 * Created by choco on 2021/1/11 19:06
 */
public interface OrderService {
    /**
     * 生成订单
     * @param admin
     * @param cartResult
     * @return
     */
    BaseResult orderSave(Admin admin, CartResult cartResult);

    /**
     * 根据订单编号查询订单
     * @param orderSn
     * @return
     */
    Order selectOrderByOrderSn(String orderSn);
}
