/*
*
* BrandMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2020-12-31
*/
package com.choco.manager.mapper;

import com.choco.manager.entity.Brand;
import com.choco.manager.entity.BrandExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface BrandMapper {
    /**
     *
     * @mbg.generated 2020-12-31
     */
    long countByExample(BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int deleteByExample(BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int deleteByPrimaryKey(Short id);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int insert(Brand record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int insertSelective(Brand record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    List<Brand> selectByExampleWithBLOBs(BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    List<Brand> selectByExample(BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    Brand selectByPrimaryKey(Short id);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExampleSelective(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExampleWithBLOBs(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByExample(@Param("record") Brand record, @Param("example") BrandExample example);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKeySelective(Brand record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKeyWithBLOBs(Brand record);

    /**
     *
     * @mbg.generated 2020-12-31
     */
    int updateByPrimaryKey(Brand record);
}
