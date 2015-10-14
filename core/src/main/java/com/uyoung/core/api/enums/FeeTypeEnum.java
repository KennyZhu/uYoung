package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * Desc:
 * <p/>Date: 2015-10-13
 * <br/>Time: 14:23
 * <br/>User: ylzhu
 */
public enum FeeTypeEnum {

    FREE(1, "免费"), AA(2, "AA");
    private int code;
    private String desc;


    FeeTypeEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static FeeTypeEnum getByCode(int code) {
        return Stream.of(FeeTypeEnum.values()).filter(feeTypeEnum -> feeTypeEnum.getCode() == code).findFirst().orElse(null);
    }
}
