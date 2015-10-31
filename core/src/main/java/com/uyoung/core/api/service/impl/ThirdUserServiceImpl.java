package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ThirdUserDao;
import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.api.service.ThirdUserService;
import com.uyoung.core.third.enums.ThirdPlatformEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
@Service
public class ThirdUserServiceImpl implements ThirdUserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdUserServiceImpl.class);
    @Autowired
    private ThirdUserDao thirdUserDao;

    @Override
    public int add(ThirdUser thirdUser) {
        if (thirdUser == null) {
            return 0;
        }
        return thirdUserDao.insert(thirdUser);
    }

    @Override
    public ThirdUser getById(Integer id) {
        if (id == null) {
            return null;
        }
        return thirdUserDao.getByUid(id);
    }

    @Override
    public ThirdUser getByThirdUid(String thirdUid, ThirdPlatformEnum thirdPlatform) {
        if (StringUtils.isBlank(thirdUid) || thirdPlatform == null) {
            LOGGER.error("#Invalid param thirdUid.");
            return null;
        }
        return thirdUserDao.getByThirdUidUserType(thirdUid, thirdPlatform.getCode());
    }
}
