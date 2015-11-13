package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * Desc:性别枚举
 * <p/>Date: 2015-11-13
 * <br/>Time: 17:22
 * <br/>User: ylzhu
 */
public enum GenderEnum {
    MAN(1), WOMAN(2);
    private int code;

    GenderEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static GenderEnum getByCode(int code) {
        return Stream.of(GenderEnum.values()).filter(genderEnum -> genderEnum.getCode() == code).findFirst().orElse(null);
    }
}
