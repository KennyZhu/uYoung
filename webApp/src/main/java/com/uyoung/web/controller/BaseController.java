package com.uyoung.web.controller;

import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.JsonUtil;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:42
 * <br/>User: ylzhu
 */
public class BaseController {
    protected String buildInvalidParamResult(){
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));
    }
}
