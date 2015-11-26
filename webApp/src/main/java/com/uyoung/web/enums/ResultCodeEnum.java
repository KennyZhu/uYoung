package com.uyoung.web.enums;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
public enum ResultCodeEnum {

    SUCCESS(100, "success"), FAIL(101, "fail"), EXCEPTION(-1, "exception"), INVALID_PARAM(-2, "invalid param");
    private final int code;
    private final String desc;

    ResultCodeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
