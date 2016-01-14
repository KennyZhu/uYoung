package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public UserInfo login(String email, String password) {
        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            LOGGER.error("Invalid param");
            return null;
        }
        return userInfoDao.getByEmailPassword(email, password);
    }


    @Override
    public int add(UserInfo userInfo) {
        if (userInfo == null) {
            return 0;
        }
        return userInfoDao.insert(userInfo);
    }

    @Override
    public UserInfo getById(Integer userId) {
        if (userId == null) {
            return null;
        }
        return userInfoDao.getById(userId);
    }

    @Override
    public UserInfo getByEmail(String email) {
        if (StringUtils.isBlank(email)) {
            return null;
        }
        return userInfoDao.getByEmail(email);
    }

    @Override
    public int updateById(UserInfo userInfo) {
        if (userInfo == null || userInfo.getId() == null) {
            return 0;
        }
        return userInfoDao.updateById(userInfo);
    }

    @Override
    public List<UserInfo> getListByIdList(List<Integer> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return Collections.emptyList();
        }
        return userInfoDao.getAvatarListByUserIdList(userIds);
    }

    @Override
    public Map<Integer, UserInfo> getMapByIdList(List<Integer> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return Collections.emptyMap();
        }
        List<UserInfo> userInfoList = getListByIdList(userIds);
        if (CollectionUtils.isEmpty(userInfoList)) {
            return Collections.emptyMap();
        }
        Map<Integer, UserInfo> result = new HashMap<>(userInfoList.size());
        for (UserInfo userInfo : userInfoList) {
            result.put(userInfo.getId(), userInfo);
        }
        return result;

    }
}
