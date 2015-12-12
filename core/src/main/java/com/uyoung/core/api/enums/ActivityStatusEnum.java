package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public enum ActivityStatusEnum {

    /**
     * 报名中
     */
    SIGNUP(0, "报名中"),
    /**
     * 进行中
     */
    ACTIVE(1, "进行中"),

    /**
     * 已完成
     */
    COMPLETE(2, "已完成"),

    /**
     * 已取消
     */
    CANCEL(3, "已取消");


    private final int status;
    private final String desc;

    ActivityStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static ActivityStatusEnum getByStatus(int status) {
        return Stream.of(ActivityStatusEnum.values()).filter(statusEnum -> statusEnum.getStatus() == status).findFirst().orElse(null);
    }


}
