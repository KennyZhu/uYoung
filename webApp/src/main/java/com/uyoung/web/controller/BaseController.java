package com.uyoung.web.controller;

import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.base.bean.Page;
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
    /**
     * @param resultData
     * @return
     */
    protected String buildSuccessJson(Object resultData) {
        return JsonUtil.getJsonString(new BaseResult(resultData));
    }

    /**
     * @return
     */
    protected String buildSuccessJson() {
        return buildSuccessJson(null);
    }

    /**
     * 参数错误
     *
     * @return
     */
    protected String buildInvalidParamJson() {
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));
    }

    /**
     * 异常
     *
     * @return
     */
    protected String buildExceptionJson() {
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.EXCEPTION.getCode(), ResultCodeEnum.EXCEPTION.getDesc()));
    }

    /**
     * 空结果
     *
     * @param page
     * @param pageSize
     * @return
     */
    protected String buildEmptyPageJson(Integer page, Integer pageSize) {
        Page result = new Page();
        if (pageSize != null) {
            result.setPageSize(pageSize);
        }
        if (page != null) {
            result.setPageNum(page);
        }
        BaseResult
                baeResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
        baeResult.setResultData(result);
        return JsonUtil.getJsonString(baeResult);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    protected UserInfo getCurrentLoginUser() {
        return null;
    }

    /**
     * 检查用户是否登录
     *
     * @return
     */
    protected boolean checkLogin() {
        return true;
    }
}
