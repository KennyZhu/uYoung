package com.uyoung.core.api.service;

import com.uyoung.core.api.model.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:用户信息
 */
public interface UserInfoService {
    /**
     * @param userInfo
     * @return
     */
    public int add(UserInfo userInfo);

    /**
     * @param userId
     * @return
     */
    public UserInfo getById(Integer userId);

    List<UserInfo> getListByIdList(List<Integer> userIds);

    Map<Integer, UserInfo> getMapByIdList(List<Integer> userIds);
}
