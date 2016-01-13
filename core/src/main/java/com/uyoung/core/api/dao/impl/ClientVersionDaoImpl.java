package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ClientVersionDao;
import com.uyoung.core.api.model.ClientVersion;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 16/1/8
 * Desc:
 */
@Repository
public class ClientVersionDaoImpl extends BaseDao<ClientVersion> implements ClientVersionDao {
    @Override
    public int insert(ClientVersion version) {
        return insert("insert", version);
    }

    @Override
    public ClientVersion getByVersion(String version) {
        return selectOne("getByVersion", version);
    }

    @Override
    public ClientVersion getLastVersion(int clientType) {
        return selectOne("getLastVersion", clientType);
    }
}
