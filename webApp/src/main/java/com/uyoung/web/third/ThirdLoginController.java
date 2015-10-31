package com.uyoung.web.third;

import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.ThirdUserService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.third.enums.ThirdPlatformEnum;
import com.uyoung.web.controller.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
@Controller
public class ThirdLoginController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdLoginController.class);

    @Autowired
    private ThirdUserService thirdUserService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/third/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(ThirdUser thirdUser) {
        if (thirdUser == null) {
            return buildInvalidParamJson();
        }
        try {
            //已经登录过
            ThirdUser currentThirdUser = thirdUserService.getByThirdUid(thirdUser.getThirdUid(), ThirdPlatformEnum.getByCode(thirdUser.getUserType()));
            if (currentThirdUser != null) {
                return buildSuccessJson(currentThirdUser.getUid());
            }
            UserInfo userInfo = buildUserInfoByThirdUser(thirdUser);
            userInfoService.add(userInfo);
            int uid = userInfo.getId();
            thirdUser.setUid(uid);
            thirdUserService.add(thirdUser);
            return buildSuccessJson(uid);
        } catch (Exception e) {
            LOGGER.error("#Third login error!ThirdUser is " + thirdUser.toString() + "Cause:", e);
            return buildExceptionJson();
        }
    }

    private UserInfo buildUserInfoByThirdUser(ThirdUser thirdUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setNickName(thirdUser.getNickName());
        userInfo.setAvatarUrl(thirdUser.getAvatarUrl());
        userInfo.setPassword(thirdUser.getThirdUid());
        userInfo.setUserType(thirdUser.getUserType());
        userInfo.setGender(thirdUser.getGender());
        return userInfo;
    }
}
