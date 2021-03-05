/*
*
* AdminMapper.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-05
*/
package com.choco.portal.mapper;

import com.choco.common.entity.Admin;
import com.choco.common.entity.AdminExample;
import com.choco.common.entity.AdminWithBLOBs;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface AdminMapper {
    /**
     *
     * @mbg.generated 2021-01-05
     */
    long countByExample(AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int deleteByExample(AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int deleteByPrimaryKey(Short adminId);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int insert(AdminWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int insertSelective(AdminWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    List<AdminWithBLOBs> selectByExampleWithBLOBs(AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    AdminWithBLOBs selectByPrimaryKey(Short adminId);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByExampleSelective(@Param("record") AdminWithBLOBs record, @Param("example") AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByExampleWithBLOBs(@Param("record") AdminWithBLOBs record, @Param("example") AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByPrimaryKeySelective(AdminWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByPrimaryKeyWithBLOBs(AdminWithBLOBs record);

    /**
     *
     * @mbg.generated 2021-01-05
     */
    int updateByPrimaryKey(Admin record);
}
