package com.uyoung.web.controller;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.ThirdUserService;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.third.ThirdUtil;
import com.uyoung.core.third.enums.ThirdPlatformEnum;
import com.uyoung.web.controller.base.LoginBaseController;
import com.uyoung.web.vo.LoginResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
@Controller
public class ThirdLoginController extends LoginBaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdLoginController.class);

    @Autowired
    private ThirdUserService thirdUserService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/third/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(ThirdUser thirdUser, HttpServletResponse response) {
        if (thirdUser == null || ThirdPlatformEnum.getByCode(thirdUser.getUserType()) == null) {
            return buildInvalidParamJson();
        }
        try {
            //已经登录过
            ThirdUser currentThirdUser = thirdUserService.getByThirdUid(thirdUser.getThirdUid(), ThirdPlatformEnum.getByCode(thirdUser.getUserType()));
            if (currentThirdUser != null) {
                String email = ThirdUtil.getEmail(currentThirdUser.getThirdUid(), currentThirdUser.getUserType());
                return buildSuccessJson(new LoginResultVo(currentThirdUser.getUid(), LoginUtil.getSessionId(email, currentThirdUser.getUid())));
            }
            LOGGER.info("#New User:" + thirdUser.toString());
            UserInfo userInfo = buildUserInfoByThirdUser(thirdUser);
            userInfoService.add(userInfo);
            int uid = userInfo.getId();
            thirdUser.setUid(uid);
            thirdUserService.add(thirdUser);
            login(response, userInfo.getEmail(), userInfo.getId());
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
        userInfo.setPasswd(thirdUser.getThirdUid());
        userInfo.setUserType(thirdUser.getUserType());
        userInfo.setGender(thirdUser.getGender());
        userInfo.setEmail(ThirdUtil.getEmail(thirdUser.getThirdUid(), thirdUser.getUserType()));
        return userInfo;
    }
}
