/*
*
* OrderGoodsMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-11
*/
package com.choco.order.mapper;

import com.choco.order.entity.OrderGoods;
import com.choco.order.entity.OrderGoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderGoodsMapper {
    /**
     *
     * @mbg.generated 2021-01-11
     */
    long countByExample(OrderGoodsExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int deleteByExample(OrderGoodsExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int deleteByPrimaryKey(Integer recId);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int insert(OrderGoods record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int insertSelective(OrderGoods record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    List<OrderGoods> selectByExample(OrderGoodsExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    OrderGoods selectByPrimaryKey(Integer recId);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByExampleSelective(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByExample(@Param("record") OrderGoods record, @Param("example") OrderGoodsExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByPrimaryKeySelective(OrderGoods record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByPrimaryKey(OrderGoods record);

    /**
     * 批量插入订单商品表
     * @param orderGoodsList
     * @return
     */
    int insertOrderGoodsBatch(@Param("orderGoodsList") List<OrderGoods> orderGoodsList);
}
