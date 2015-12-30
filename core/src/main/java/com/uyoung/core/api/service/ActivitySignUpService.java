package com.uyoung.core.api.service;

import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;

import java.util.Date;
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
     * @param aid
     * @param uid
     * @return
     */
    public ActivitySignUp getByAidUid(Integer aid, Integer uid);


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

    /**
     * @param uid
     * @param aid
     * @param statusEnum
     * @return
     */
    int updateStatusByUidAid(Integer uid, Integer aid, ActivitySignUpStatusEnum statusEnum);

    /**
     * 获取指定活动的所有报名
     *
     * @param activityId
     * @return
     */
    List<ActivitySignUp> getListByActivityId(Integer activityId);

    /**
     * 获取指定时间内的所有报名信息
     *
     * @param uid
     * @param beginTime
     * @return
     */
    List<ActivitySignUp> getListByUidBeginTime(Integer uid, Date beginTime);
}
