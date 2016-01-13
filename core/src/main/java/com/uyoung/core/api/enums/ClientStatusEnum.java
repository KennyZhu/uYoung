package com.uyoung.core.api.enums;

import java.util.stream.Stream;

/**
 * User: KennyZhu
 * Date: 16/1/9
 * Desc:
 */
public enum ClientStatusEnum {

    AUDITED(1),

    NOT_AUDIT(0);


    private int status;


    private ClientStatusEnum(int status) {
        this.status = status;
    }

    public static ClientStatusEnum getByStatus(int status) {
        return Stream.of(ClientStatusEnum.values()).filter(clientStatus -> clientStatus.getStatus() == status).findFirst().orElse(null);
    }

    public int getStatus() {
        return status;
    }
}
