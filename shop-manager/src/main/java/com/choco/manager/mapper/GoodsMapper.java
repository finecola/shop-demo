/*
*
* GoodsMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-12-31
*/
package com.choco.manager.mapper;

import com.choco.manager.entity.Goods;
import com.choco.manager.entity.GoodsExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GoodsMapper {
    /**
     *
     * @mbg.generated 2020-12-31
     */
    long countByExample(GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int deleteByExample(GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int deleteByPrimaryKey(Integer goodsId);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int insert(Goods record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int insertSelective(Goods record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    List<Goods> selectByExampleWithBLOBs(GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    List<Goods> selectByExample(GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    Goods selectByPrimaryKey(Integer goodsId);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExampleSelective(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExampleWithBLOBs(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExample(@Param("record") Goods record, @Param("example") GoodsExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKeySelective(Goods record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKeyWithBLOBs(Goods record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKey(Goods record);
}
