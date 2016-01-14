package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ClientVersionDao;
import com.uyoung.core.api.enums.ClientTypeEnum;
import com.uyoung.core.api.model.ClientVersion;
import com.uyoung.core.api.service.ClientVersionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 16/1/8
 * Desc:
 */
@Service("clientVersionService")
public class ClientVersionServiceImpl implements ClientVersionService {

    @Autowired
    private ClientVersionDao versionDao;

    @Override
    public boolean add(ClientVersion version) {
        if (version == null) {
            return false;
        }
        return versionDao.insert(version) == 1;
    }

    @Override
    public ClientVersion getByVersion(String version) {
        if (StringUtils.isBlank(version)) {
            return null;
        }
        return versionDao.getByVersion(version);
    }

    @Override
    public ClientVersion getLastVersion(ClientTypeEnum clientTypeEnum) {
        if (clientTypeEnum == null) {
            return null;
        }
        return versionDao.getLastVersion(clientTypeEnum.getType());
    }
}
