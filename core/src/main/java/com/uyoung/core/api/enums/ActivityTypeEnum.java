package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * Desc:
 * <p/>Date: 2015-10-14
 * <br/>Time: 16:51
 * <br/>User: ylzhu
 */
public enum ActivityTypeEnum {
    SCENERY(1, "风景"),

    PERSON(2, "人像"),

    WEDDING(3, "婚礼"),

    FAMILY(4, "家庭");

    private int type;
    private String desc;

    ActivityTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public int getType() {
        return type;
    }

    public static ActivityTypeEnum getByType(int type) {
        return Stream.of(ActivityTypeEnum.values()).filter(activityTypeEnum -> activityTypeEnum.getType() == type).findFirst().orElse(null);
    }
}
