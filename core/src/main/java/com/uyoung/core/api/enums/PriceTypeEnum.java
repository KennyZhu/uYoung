package com.uyoung.core.api.enums;

/**
 * Desc:
 * <p/>Date: 2015-10-13
 * <br/>Time: 14:23
 * <br/>User: ylzhu
 */
public enum PriceTypeEnum {

    FREE(1), AA(2);
    private int code;

    PriceTypeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
