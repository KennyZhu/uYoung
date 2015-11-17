package com.uyoung.web.controller;

import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.api.service.ActivitySignUpService;
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

    @RequestMapping(value = "/activity/signUp")
    @ResponseBody
    public String signUp(ActivitySignUp activitySignUp) {
        if (activitySignUp == null) {
            return buildInvalidParamJson();
        }
        try {
            signUpService.add(activitySignUp);
        } catch (Exception e) {
            LOGGER.error("#SignUp activity error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }
}
