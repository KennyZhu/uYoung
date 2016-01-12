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
     * @param uid
     * @return
     */
    public UserInfo getById(Integer uid);

    /**
     * @param email
     * @return
     */
    public UserInfo getByEmail(String email);

    /**
     * @param userInfo
     * @return
     */
    public int updateById(UserInfo userInfo);

    /**
     * @param userIds
     * @return
     */
    List<UserInfo> getListByIdList(List<Integer> userIds);

    /**
     * @param userIds
     * @return
     */
    Map<Integer, UserInfo> getMapByIdList(List<Integer> userIds);
}
