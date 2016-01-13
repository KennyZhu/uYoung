package com.uyoung.web.controller;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.controller.base.LoginBaseController;
import com.uyoung.web.enums.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
@Controller
public class LoginController extends LoginBaseController {

    @Autowired
    private UserInfoService userInfoService;
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(LoginController.class);

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String email, String password, HttpServletRequest request, HttpServletResponse response) {

        if (StringUtils.isBlank(email) || StringUtils.isBlank(password)) {
            return buildInvalidParamJson();
        }
        try {
            boolean isLogin = userInfoService.login(email, password);
            if (isLogin) {
                String code = LoginUtil.getSessionId(email);
                return buildSuccessJson(code);
            }
            LOGGER.warn("#Not login email is " + email + " password  is " + password);
            return buildFailJson(ResultCodeEnum.NOT_LOGIN.getDesc());

        } catch (Exception e) {
            LOGGER.error("#Login error.Cause:", e);
            return buildExceptionJson();
        }
    }

}
