package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.UserInfoDao;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import org.apache.commons.collections.CollectionUtils;
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
    @Autowired
    private UserInfoDao userInfoDao;

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
