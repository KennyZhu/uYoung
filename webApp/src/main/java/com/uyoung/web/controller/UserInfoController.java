package com.uyoung.web.controller;

import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-10-14
 * <br/>Time: 17:57
 * <br/>User: ylzhu
 */
@Controller
public class UserInfoController extends BaseController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/userInfo/getByUid")
    @ResponseBody
    public String getUserInfoById(Integer uid) {
        if (uid == null) {
            return buildInvalidParamJson();
        }

        BaseResult baseResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());

        try {
            UserInfo userInfo = userInfoService.getById(uid);
            baseResult.setResultData(userInfo);
        } catch (Exception e) {
            baseResult.setResult(ResultCodeEnum.EXCEPTION.getCode());
            baseResult.setResultDesc(ResultCodeEnum.EXCEPTION.getDesc());
        }

        return JsonUtil.getJsonString(baseResult);
    }

    @RequestMapping(value = "/userInfo/updateById", method = RequestMethod.POST)
    @ResponseBody
    public String updateById(UserInfo userInfo) {
        if (userInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            userInfoService.updateById(userInfo);
            return buildSuccessJson();
        } catch (Exception e) {
            return buildExceptionJson();
        }
    }
}
