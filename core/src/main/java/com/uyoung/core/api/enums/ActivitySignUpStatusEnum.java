package com.uyoung.core.api.enums;

/**
 * User: KennyZhu
 * Date: 15/11/21
 * Desc: 活动报名状态
 */
public enum ActivitySignUpStatusEnum {

    /**
     * 初始状态
     */
    INIT(0),

    /**
     * 报名成功
     */
    SUCCESS(1),

    /**
     * 取消报名
     */
    CANCEL(2);
    private int status;

    private ActivitySignUpStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
