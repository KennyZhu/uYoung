package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ClientVersion;

/**
 * User: KennyZhu
 * Date: 16/1/8
 * Desc:
 */
public interface ClientVersionDao {

    int insert(ClientVersion version);

    ClientVersion getByVersion(String version);

    ClientVersion getLastVersion(int clientType);
}
