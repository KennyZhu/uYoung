package com.uyoung.web.controller;

import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
public class RegController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/reg/reg", method = RequestMethod.POST)
    @ResponseBody
    public String reg(UserInfo userInfo) {
        if (userInfo == null) {
            return buildInvalidParamJson();
        }
        int result = userInfoService.add(userInfo);
        if (result == 1) {
            return JsonUtil.getJsonString(buildSuccessJson());
        } else {
            return JsonUtil.getJsonString(buildExceptionJson());
        }
    }
}
