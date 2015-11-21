package com.uyoung.core.api.enums;

/**
 * User: KennyZhu
 * Date: 15/11/21
 * Desc: 活动报名状态
 */
public enum ActivitySignUpStatusEnum {

    INIT(0), SUCCESS(1), CANCEL(2);
    private int status;

    private ActivitySignUpStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

}
