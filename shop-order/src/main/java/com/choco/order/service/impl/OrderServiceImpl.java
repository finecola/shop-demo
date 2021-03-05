package com.choco.order.service.impl;

import com.choco.common.entity.Admin;
import com.choco.common.enums.OrderStatus;
import com.choco.common.enums.PayStatus;
import com.choco.common.enums.SendStatus;
import com.choco.common.result.BaseResult;
import com.choco.order.entity.Order;
import com.choco.order.entity.OrderExample;
import com.choco.order.entity.OrderGoods;
import com.choco.order.mapper.OrderGoodsMapper;
import com.choco.order.mapper.OrderMapper;
import com.choco.order.service.OrderService;
import com.choco.rpc.vo.CartResult;
import com.choco.rpc.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by choco on 2021/1/11 19:07
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderGoodsMapper orderGoodsMapper;
    @Value("redis.order.increment")
    private String redisOrderIncrement;
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public BaseResult orderSave(Admin admin, CartResult cartResult) {
        Order order = new Order();
        //订单编号
        String orderSn = "shop_" + DateTimeFormatter.ofPattern("yyMMddHHmmss").format(LocalDateTime.now())
                + "_" + getIncrement(redisOrderIncrement);
        order.setOrderSn(orderSn);
        //设置订单id
        order.setUserId(admin.getAdminId().intValue());
        //订单状态(未确认)
        order.setOrderStatus(OrderStatus.no_confirm.getStatus());
        //发货状态
        order.setOrderStatus(SendStatus.no_pay.getStatus());
        //未支付
        order.setOrderStatus(PayStatus.no_pay.getStatus());

        order.setGoodsPrice(cartResult.getTotalPrice());
        order.setOrderAmount(cartResult.getTotalPrice());
        order.setTotalAmount(cartResult.getTotalPrice());
        long addTime = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
        //订单时间
        order.setAddTime((int) addTime);

        int result = orderMapper.insertSelective(order);

        if (result > 0) {
            ArrayList<OrderGoods> orderGoodsList = new ArrayList<>();
            for (CartVo cartVo : cartResult.getCartList()) {
                OrderGoods orderGoods = new OrderGoods();
                //设置商品id
                orderGoods.setGoodsId(cartVo.getGoodsId());
                //设置订单id
                orderGoods.setOrderId(order.getOrderId());
                //设置商品名称
                orderGoods.setGoodsName(cartVo.getGoodsName());
                //设置商品价格
                //设置商品数量
                //设置订单方式
                //设置发货状态
                orderGoodsList.add(orderGoods);
            }
            //执行批量插入
            result = orderGoodsMapper.insertOrderGoodsBatch(orderGoodsList);
            if (result > 0) {
                BaseResult success = BaseResult.success();
                success.setMessage(orderSn);
                return success;
            }
        }
        return BaseResult.error();
    }

    @Override
    public Order selectOrderByOrderSn(String orderSn) {
        //创造查询对象
        OrderExample example = new OrderExample();
        //
        example.createCriteria().andOrderSnEqualTo(orderSn);
        //查询order
        List<Order> orders = orderMapper.selectByExample(example);
        //健壮性判断
        if (CollectionUtils.isEmpty(orders) || orders.size() > 1) {
            return null;
        }
        //返回第一个
        return orders.get(0);
    }

    /**
     * 返回订单编号的自增key
     *
     * @param key
     * @return
     */
    public long getIncrement(String key) {
        RedisAtomicLong redisAtomicLong = new RedisAtomicLong(key, redisTemplate.getConnectionFactory());
        return redisAtomicLong.getAndIncrement();
    }
}
