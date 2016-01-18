package com.uyoung.web.controller;

import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.exception.BusinessException;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.handler.ActivitySignUpHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-11-16
 * <br/>Time: 18:19
 * <br/>User: ylzhu
 */
@Controller
public class ActivitySignUpController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivitySignUpController.class);
    @Autowired
    private ActivitySignUpService signUpService;

    @Autowired
    private ActivitySignUpHandler handler;

    /**
     * 报名
     *
     * @return
     */
    @RequestMapping(value = "/activity/signUp")
    @ResponseBody
    public String signUp(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return buildInvalidParamJson();
        }
        try {
            boolean result = handler.signUp(uid, activityId);
            if (!result) {
                LOGGER.error("#SignUp failed.Uid is " + uid + " activityId is " + activityId);
                return buildFailJson();
            }
        } catch (BusinessException busE) {
            LOGGER.error("#SignUp activity error.Cause:", busE);
            return buildFailJson(ResultCodeEnum.getByCode(Integer.valueOf(busE.getMessage())).getDesc());
        } catch (Exception e) {
            LOGGER.error("#SignUp activity error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 取消报名
     *
     * @param uid
     * @param activityId
     * @return
     */
    @RequestMapping(value = "/activity/calSignUp")
    @ResponseBody
    public String calSignUp(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return buildInvalidParamJson();
        }
        try {
            boolean result = signUpService.cancel(uid, activityId);
            if (!result) {
                LOGGER.error("#Cancel failed.aid is " + activityId + " uid is " + uid);
                return buildFailJson();
            }
        } catch (Exception e) {
            LOGGER.error("#Cancel aid:" + activityId + " uid:" + uid + " error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 确认报名
     *
     * @return
     */
    @RequestMapping(value = "/activity/conSignUp")
    @ResponseBody
    public String confirmSignUp(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return buildInvalidParamJson();
        }
        try {
            signUpService.updateStatusByUidAid(uid, activityId, ActivitySignUpStatusEnum.CONFIRM);
        } catch (Exception e) {
            LOGGER.error("#Confirm signUp aid:" + activityId + " uid:" + uid);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 检查报名
     *
     * @return
     */
    @RequestMapping(value = "/activity/getSignUp")
    @ResponseBody
    public String getByUidActivityId(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return buildInvalidParamJson();
        }
        try {
            ActivitySignUp activitySignUp = signUpService.getByAidUid(activityId, uid);
            return buildSuccessJson(activitySignUp);
        } catch (Exception e) {
            LOGGER.error("#Confirm signUp aid:" + activityId + " uid:" + uid);
            return buildExceptionJson();
        }
    }
}
