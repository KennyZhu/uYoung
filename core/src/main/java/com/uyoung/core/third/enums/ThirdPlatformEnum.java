package com.uyoung.core.third.enums;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 15:48
 * <br/>User: ylzhu
 */
public enum ThirdPlatformEnum {

    DOUBAN("douban"), WEIXIN("weixin"), WEIBO("weibo");
    private String desc;

    ThirdPlatformEnum(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
