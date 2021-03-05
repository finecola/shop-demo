/*
*
* GoodsImageMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-01
*/
package com.choco.manager.mapper;

import com.choco.manager.entity.GoodsImage;
import com.choco.manager.entity.GoodsImageExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GoodsImageMapper {
    /**
     *
     * @mbg.generated 2021-01-01
     */
    long countByExample(GoodsImageExample example);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int deleteByExample(GoodsImageExample example);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int deleteByPrimaryKey(Integer imgId);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int insert(GoodsImage record);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int insertSelective(GoodsImage record);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    List<GoodsImage> selectByExample(GoodsImageExample example);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    GoodsImage selectByPrimaryKey(Integer imgId);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int updateByExampleSelective(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int updateByExample(@Param("record") GoodsImage record, @Param("example") GoodsImageExample example);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int updateByPrimaryKeySelective(GoodsImage record);

    /**
     *
     * @mbg.generated 2021-01-01
     */
    int updateByPrimaryKey(GoodsImage record);
}
