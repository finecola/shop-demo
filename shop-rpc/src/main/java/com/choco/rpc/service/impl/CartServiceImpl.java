package com.choco.rpc.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.choco.common.entity.Admin;
import com.choco.common.result.BaseResult;
import com.choco.common.utils.JsonUtil;
import com.choco.rpc.service.CartService;
import com.choco.rpc.vo.CartResult;
import com.choco.rpc.vo.CartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by choco on 2021/1/7 14:13
 */
@Service(interfaceClass = CartService.class)
@Component
public class CartServiceImpl implements CartService {
    @Autowired
    private RedisTemplate redisTemplate;
    @Value("${user.cart}")
    private String userCart;
    //提取公共模板

    @Override
    public BaseResult addCart(CartVo cartVo, Admin admin) {
        //判断用户
        if (admin == null || admin.getAdminId() == null) {
            return BaseResult.error();
        }
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        //获取购物车
        Map<String, String> cartVoMap = hashOperations.entries(userCart + ":" + admin.getAdminId());
        //
        if (CollectionUtils.isEmpty(cartVoMap)) {
            //如果整个购物车为空
            cartVoMap = new HashMap<String, String>();
            cartVoMap.put(String.valueOf(cartVo.getGoodsId()), JsonUtil.object2JsonStr(cartVo));
        } else {
            //获取已存在的cartvo.
            String goodsJson = cartVoMap.get(String.valueOf(cartVo.getGoodsId()));
            //
            if (StringUtils.isEmpty(goodsJson)) {
                //如果购物车的这个商品为空
                //直接存入map
                cartVoMap.put(String.valueOf(cartVo.getGoodsId()), JsonUtil.object2JsonStr(cartVo));
            } else {

                CartVo vo = JsonUtil.jsonStr2Object(goodsJson, CartVo.class);
                //重新设置商品数量
                vo.setGoodsNum(vo.getGoodsNum() + cartVo.getGoodsNum());

                //重新设置商品价格
                vo.setMarketPrice(cartVo.getMarketPrice());

                //这里需要重新存入vo, 不是cartVo
                cartVoMap.put(String.valueOf(cartVo.getGoodsId()), JsonUtil.object2JsonStr(vo));
            }
        }
        hashOperations.putAll(userCart + ":" + admin.getAdminId(), cartVoMap);
        return BaseResult.success();
    }

    Integer cartNum = 0;

    @Override
    public Integer getCartNums(Admin admin) {
        //判断用户
        if (admin == null || admin.getAdminId() == null) {
            return 0;
        }
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();
        //通过key获取redis购物车
        Map<String, String> cartMap = hashOperations.entries(userCart + ":" + admin.getAdminId());

        if (!CollectionUtils.isEmpty(cartMap)) {
            for (Map.Entry<String, String> entry : cartMap.entrySet()) {
                // entry.getValue()为json
                CartVo cartVo = JsonUtil.jsonStr2Object(entry.getValue(), CartVo.class);
                cartNum += cartVo.getGoodsNum();
            }
            return cartNum;
        }
        return 0;
    }

    @Override
    public CartResult getCartList(Admin admin) {
        if (null == admin && null == admin.getAdminId()) {
            return null;
        }
        CartResult cartResult = null;
        HashOperations<String, String, String> hashOperations = redisTemplate.opsForHash();

        Map<String, String> cartMap = hashOperations.entries(userCart + ":" + admin.getAdminId());

        if (!StringUtils.isEmpty(cartMap)) {
            cartResult = new CartResult();
            //把map的value转换为cartList
            List<CartVo> cartVoList = cartMap.values().stream().map(e -> JsonUtil.jsonStr2Object(e, CartVo.class)).collect(Collectors.toList());
            //计算总价
            BigDecimal totalPrice = cartVoList.stream().map(e -> e.getMarketPrice().multiply(new BigDecimal(String.valueOf(e.getGoodsNum())))).reduce(BigDecimal.ZERO, BigDecimal::add);
            //采取保留2位, 四舍五入的方式
            totalPrice.setScale(2, BigDecimal.ROUND_HALF_UP);
            cartResult.setCartList(cartVoList);
            cartResult.setTotalPrice(totalPrice);

            return cartResult;
        }
        return null;
    }

    @Override
    public BaseResult clearCart(Admin admin) {
        if (null == admin && null == admin.getAdminId()) {
            return null;
        }

        HashOperations hashOperations = redisTemplate.opsForHash();
        //获取购物车,判断是否为空
        Map<String, String> entries = hashOperations.entries(userCart + ":" + admin.getAdminId());
        if (!StringUtils.isEmpty(entries)) {
            //为空,则删除对于的key
            redisTemplate.delete(userCart + ":" + admin.getAdminId());
            return BaseResult.success();
        }
        return BaseResult.error();
    }
}
