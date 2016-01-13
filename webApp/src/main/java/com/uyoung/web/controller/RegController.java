package com.uyoung.web.controller;

import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.enums.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
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
public class RegController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RegController.class);

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/reg/reg", method = RequestMethod.POST)
    @ResponseBody
    public String reg(UserInfo userInfo) {
        if (userInfo == null || StringUtils.isBlank(userInfo.getEmail())) {
            return buildInvalidParamJson();
        }
        try {
            UserInfo record = userInfoService.getByEmail(userInfo.getEmail());
            if (record != null) {
                LOGGER.warn("#Email:" + userInfo.getEmail() + " exist.");
                return buildFailJson(ResultCodeEnum.USER_EMAIL_EXIST);
            }
            int result = userInfoService.add(userInfo);
            if (result == 1) {
                return buildSuccessJson();
            } else {
                return buildFailJson();
            }
        } catch (Exception e) {
            LOGGER.error("#Reg error.Cause:", e);
            return buildExceptionJson();
        }
    }
}
