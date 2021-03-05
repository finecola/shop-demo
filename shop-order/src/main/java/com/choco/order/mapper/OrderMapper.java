/*
*
* OrderMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-11
*/
package com.choco.order.mapper;

import com.choco.order.entity.Order;
import com.choco.order.entity.OrderExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface OrderMapper {
    /**
     *
     * @mbg.generated 2021-01-11
     */
    long countByExample(OrderExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int deleteByExample(OrderExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int deleteByPrimaryKey(Integer orderId);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int insert(Order record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int insertSelective(Order record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    List<Order> selectByExample(OrderExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    Order selectByPrimaryKey(Integer orderId);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     *
     * @mbg.generated 2021-01-11
     */
    int updateByPrimaryKey(Order record);
}
