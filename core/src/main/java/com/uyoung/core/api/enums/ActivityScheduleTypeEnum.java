package com.uyoung.core.api.enums;

/**
 * User: KennyZhu
 * Date: 16/4/6
 * Desc:
 */
public enum ActivityScheduleTypeEnum {
    /**
     *
     */
    BEGIN(1),

    /**
     *
     */
    END(2);

    private int type;

    private ActivityScheduleTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
