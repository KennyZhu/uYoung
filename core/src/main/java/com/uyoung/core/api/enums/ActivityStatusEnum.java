package com.uyoung.core.api.enums;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public enum ActivityStatusEnum {
    ACTIVE(1);
    private int status;

    ActivityStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
