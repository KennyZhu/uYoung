package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public enum ActivityStatusEnum {
    ACTIVE(1);
    private final int status;

    ActivityStatusEnum(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public static ActivityStatusEnum getByStatus(int status) {
        return Stream.of(ActivityStatusEnum.values()).filter(statusEnum -> statusEnum.getStatus() == status).findFirst().orElse(null);
    }


}
