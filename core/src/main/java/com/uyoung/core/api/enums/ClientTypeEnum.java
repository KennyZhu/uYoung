package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 16/1/13
 * Desc:
 */
public enum ClientTypeEnum {

    ANDROID(1, "android"),

    IPHONE(2, "iphone");

    private int type;
    private String desc;

    private ClientTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static ClientTypeEnum getByType(int type) {
        return Stream.of(ClientTypeEnum.values()).filter(clientTypeEnum -> clientTypeEnum.getType() == type).findFirst().orElse(null);
    }

}
