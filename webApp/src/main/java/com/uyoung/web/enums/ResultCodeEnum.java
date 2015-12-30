package com.uyoung.web.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:返回码
 */
public enum ResultCodeEnum {

    SUCCESS(100, "success"),
    FAIL(101, "fail"),
    EXCEPTION(-1, "exception"),
    INVALID_PARAM(-2, "invalid param"),

    /**
     * 活动不存在
     */
    ACTIVITY_NOT_EXIST(-100, "活动不存在"),


    /**
     * 活动已经开始
     */
    ACTIVITY_STARTED(-101, "活动已经开始"),

    /**
     * 活动已经取消
     */
    ACTIVITY_CANCEL(-102, "活动已经取消"),

    /**
     * 活动已经结束
     */
    ACTIVITY_COMPLETED(-103, "活动已经结束"),

    /**
     * 活动不能报名
     */
    ACTIVITY_NOT_SIGN_UP(-104, "活动已经不能报名"),

    /**
     * 不能删除别人的相册
     */
    ALBUM_DELETE_NOT_USERS(-105, "不能删除别人的相册"),

    /**
     * 没有找到相册
     */
    ALBUM_NOT_FOUND(-106, "没有找到相册");


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

    public static ResultCodeEnum getByCode(int code) {
        return Stream.of(ResultCodeEnum.values()).filter(resultCodeEnum -> resultCodeEnum.getCode() == code).findFirst().orElse(null);
    }
}
