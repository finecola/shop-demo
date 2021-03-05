package com.choco.common.enums;

/**
 * Created by choco on 2020/12/29 16:31
 * 自定义登录返回状态码的枚举类.
 */
@SuppressWarnings("all")
public enum BaseEnumResult {
    SUCCESS(200, "成功"),
    ERROR(400, "失败"),
    PASS_ERROE_01(501, "两次输入密码不一致"),
    PASS_ERROE_02(502, "原始密码不正确"),
    PASS_ERROE_03(503, "验证码错误"),
    PASS_ERROE_04(504, "用户名或密码错误");

    private Integer code;
    private String message;

    BaseEnumResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}

