package com.uyoung.core.api.service;

import com.uyoung.core.api.model.UserInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
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
    public UserInfo getById(int userId);
}
