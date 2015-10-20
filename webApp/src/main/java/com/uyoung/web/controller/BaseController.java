package com.uyoung.web.controller;

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
        result.setPageSize(pageSize);
        result.setPageNum(page);
        return JsonUtil.getJsonString(result);
    }
}