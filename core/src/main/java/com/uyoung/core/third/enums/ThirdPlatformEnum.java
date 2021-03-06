package com.uyoung.core.third.enums;

import java.util.stream.Stream;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 15:48
 * <br/>User: ylzhu
 */
public enum ThirdPlatformEnum {

    DOUBAN(1, "douban"), QQ(2, "qq"), WEIBO(3, "weibo");
    private int code;
    private String desc;

    ThirdPlatformEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static ThirdPlatformEnum getByCode(int code) {
        return Stream.of(ThirdPlatformEnum.values()).filter(thirdPlatformEnum -> thirdPlatformEnum.getCode() == code).findFirst().orElse(null);
    }

    public String getEmailSuffix() {
        return "@" + this.desc + ".com";
    }
}
