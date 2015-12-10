package com.uyoung.core.api.service;

import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivitySignUpService {

    /**
     * 增加报名记录
     *
     * @param activitySignUp
     * @return
     */
    public int add(ActivitySignUp activitySignUp);


    /**
     * 取消报名
     *
     * @param aid
     * @param uid
     * @return
     */
    public int cancel(Integer aid, Integer uid);

    /**
     * 获取报名信息
     *
     * @param id
     * @return
     */
    public ActivitySignUp getById(int id);

    int updateStatusByUidAid(Integer uid, Integer aid, ActivitySignUpStatusEnum statusEnum);

    /**
     * 更新活动状态
     *
     * @param aid
     * @param activityStatusEnum
     * @return
     */
    int updateActivityStatusByAid(Integer aid, ActivityStatusEnum activityStatusEnum);


    /**
     * 获取指定活动的所有报名
     *
     * @param activityId
     * @return
     */
    List<ActivitySignUp> getListByActivityId(Integer activityId);

    /**
     * 获取用户报名的指定状态的活动
     *
     * @param uid
     * @param activityStatusEnums
     * @return
     */
    List<ActivitySignUp> getListByUidActivityStatusList(Integer uid, List<ActivityStatusEnum> activityStatusEnums);
}
