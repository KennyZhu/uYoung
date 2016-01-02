package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 16/1/1
 * Desc:
 */
public enum SortEnum {

    /**
     * 升序
     */
    ASC(1, "asc"),

    /**
     * 降序
     */
    DESC(2, "desc");

    private SortEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    private int code;
    private String value;

    public int getCode() {
        return code;
    }


    public String getValue() {
        return value;
    }

    public static SortEnum getByCode(int code) {
        return Stream.of(SortEnum.values()).filter(sortEnum -> sortEnum.getCode() == code).findFirst().orElse(null);
    }
}
