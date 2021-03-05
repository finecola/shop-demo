/*
*
* GoodsategoryMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-12-28
*/
package com.choco.rpc.mapper;

import com.choco.rpc.entity.GoodsCategoryExample;
import com.choco.rpc.entity.GoodsCategory;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface GoodsCategoryMapper {
    /**
     *
     * @mbg.generated 2020-12-28
     */
    long countByExample(GoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int deleteByExample(GoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int deleteByPrimaryKey(Short id);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int insert(GoodsCategory record);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int insertSelective(GoodsCategory record);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    List<GoodsCategory> selectByExample(GoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    GoodsCategory selectByPrimaryKey(Short id);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int updateByExampleSelective(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int updateByExample(@Param("record") GoodsCategory record, @Param("example") GoodsCategoryExample example);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int updateByPrimaryKeySelective(GoodsCategory record);

    /**
     *
     * @mbg.generated 2020-12-28
     */
    int updateByPrimaryKey(GoodsCategory record);
}
