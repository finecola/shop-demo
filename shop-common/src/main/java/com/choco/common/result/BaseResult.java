package com.choco.common.result;

import com.choco.common.enums.BaseEnumResult;
import com.github.pagehelper.PageInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by choco on 2020/12/29 16:40
 * 公共保存对象返回对象
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResult implements Serializable {
    // 状态编码
    private Integer code;
    // 状态描述
    private String message;
    // 分页信息
    PageInfo<?> pageInfo;

    public static BaseResult success() {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseEnumResult.SUCCESS.getCode());
        baseResult.setMessage(BaseEnumResult.SUCCESS.getMessage());
        return baseResult;
    }

    //返回信息,带分页对象
    public static BaseResult success(PageInfo<?> pageInfo) {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseEnumResult.SUCCESS.getCode());
        baseResult.setMessage(BaseEnumResult.SUCCESS.getMessage());
        baseResult.setPageInfo(pageInfo);
        return baseResult;
    }

    public static BaseResult error() {
        BaseResult baseResult = new BaseResult();
        baseResult.setCode(BaseEnumResult.ERROR.getCode());
        baseResult.setMessage(BaseEnumResult.ERROR.getMessage());
        return baseResult;
    }
}
