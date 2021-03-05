/*
*
* Admin.java
* Copyright(C) 2017-2020 fendo公司
* @date 2021-01-05
*/
package com.choco.common.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class Admin implements Serializable {
    /**
     * 用户id
     */
    private Short adminId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * email
     */
    private String email;

    /**
     * 密码
     */
    private String password;

    /**
     * 秘钥
     */
    private String ecSalt;

    /**
     * 添加时间
     */
    private Integer addTime;

    /**
     * 最后登录时间
     */
    private Integer lastLogin;

    /**
     * 最后登录ip
     */
    private String lastIp;

    /**
     * lang_type
     */
    private String langType;

    /**
     * agency_id
     */
    private Short agencyId;

    /**
     * suppliers_id
     */
    private Short suppliersId;


    /**
     * 角色id
     */
    private Short roleId;

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     * @return admin_id 用户id
     */
    public Short getAdminId() {
        return adminId;
    }

    /**
     * 用户id
     * @param adminId 用户id
     */
    public void setAdminId(Short adminId) {
        this.adminId = adminId;
    }

    /**
     * 用户名
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * email
     * @return email email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 秘钥
     * @return ec_salt 秘钥
     */
    public String getEcSalt() {
        return ecSalt;
    }

    /**
     * 秘钥
     * @param ecSalt 秘钥
     */
    public void setEcSalt(String ecSalt) {
        this.ecSalt = ecSalt == null ? null : ecSalt.trim();
    }

    /**
     * 添加时间
     * @return add_time 添加时间
     */
    public Integer getAddTime() {
        return addTime;
    }

    /**
     * 添加时间
     * @param addTime 添加时间
     */
    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    /**
     * 最后登录时间
     * @return last_login 最后登录时间
     */
    public Integer getLastLogin() {
        return lastLogin;
    }

    /**
     * 最后登录时间
     * @param lastLogin 最后登录时间
     */
    public void setLastLogin(Integer lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * 最后登录ip
     * @return last_ip 最后登录ip
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 最后登录ip
     * @param lastIp 最后登录ip
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp == null ? null : lastIp.trim();
    }

    /**
     * lang_type
     * @return lang_type lang_type
     */
    public String getLangType() {
        return langType;
    }

    /**
     * lang_type
     * @param langType lang_type
     */
    public void setLangType(String langType) {
        this.langType = langType == null ? null : langType.trim();
    }

    /**
     * agency_id
     * @return agency_id agency_id
     */
    public Short getAgencyId() {
        return agencyId;
    }

    /**
     * agency_id
     * @param agencyId agency_id
     */
    public void setAgencyId(Short agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * suppliers_id
     * @return suppliers_id suppliers_id
     */
    public Short getSuppliersId() {
        return suppliersId;
    }

    /**
     * suppliers_id
     * @param suppliersId suppliers_id
     */
    public void setSuppliersId(Short suppliersId) {
        this.suppliersId = suppliersId;
    }
    /**
     * 角色id
     * @return role_id 角色id
     */
    public Short getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId 角色id
     */
    public void setRoleId(Short roleId) {
        this.roleId = roleId;
    }

    /**
     *
     * @mbg.generated 2021-01-05
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adminId=").append(adminId);
        sb.append(", userName=").append(userName);
        sb.append(", email=").append(email);
        sb.append(", password=").append(password);
        sb.append(", ecSalt=").append(ecSalt);
        sb.append(", addTime=").append(addTime);
        sb.append(", lastLogin=").append(lastLogin);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", langType=").append(langType);
        sb.append(", agencyId=").append(agencyId);
        sb.append(", suppliersId=").append(suppliersId);
        sb.append(", roleId=").append(roleId);
        sb.append("]");
        return sb.toString();
    }
}
