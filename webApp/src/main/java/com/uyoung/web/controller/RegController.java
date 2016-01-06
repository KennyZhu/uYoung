package com.uyoung.web.controller;

import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.controller.base.BaseController;
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

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/reg/reg", method = RequestMethod.POST)
    @ResponseBody
    public String reg(UserInfo userInfo) {
        if (userInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            int result = userInfoService.add(userInfo);
            if (result == 1) {
                return buildSuccessJson();
            } else {
                return buildFailJson();
            }
        } catch (Exception e) {
            return buildExceptionJson();
        }
    }
}
