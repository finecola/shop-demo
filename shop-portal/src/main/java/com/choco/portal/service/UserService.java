package com.choco.portal.service;

import com.choco.common.entity.AdminWithBLOBs;
import com.choco.common.result.BaseResult;

/**
 * Created by choco on 2021/1/12 13:15
 */
public interface UserService {

    /**
     * 用户保存到数据库, 就是用户注册
     * @param admin
     * @return
     */
    BaseResult userSave(AdminWithBLOBs admin);
}
