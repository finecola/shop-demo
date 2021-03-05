package com.choco.sso.service;

import com.choco.common.entity.Admin;

/**
 * Created by choco on 2021/1/5 22:29
 */
public interface SSOService {
    /**
     * 返回ticket
     */
    String login(Admin admin);

    /**
     * 验证ticket
     */
    Admin validate(String ticket);

    /**
     * 删除cookie
     */
    void logout(String ticket);
}
