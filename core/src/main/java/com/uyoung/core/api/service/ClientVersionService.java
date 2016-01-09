package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ClientVersion;

/**
 * User: KennyZhu
 * Date: 16/1/8
 * Desc:
 */
public interface ClientVersionService {
    boolean add(ClientVersion version);

    ClientVersion getByVersion(String version);
}
