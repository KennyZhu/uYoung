package com.uyoung.web.controller.base;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.UserInfo;
import com.uyoung.core.api.service.UserInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

/**
 * Desc:Base Controller
 * <p/>Date: 2015-10-20
 * <br/>Time: 16:42
 * <br/>User: ylzhu
 */
@Controller
public class BaseController {

    @Autowired
    private UserInfoService userInfoService;

    /**
     * @param resultData
     * @return
     */
    protected String buildSuccessJson(Object resultData) {
        return buildSuccessJson(new BaseResult(resultData));
    }

    /**
     * @param result
     * @return
     */
    protected String buildSuccessJson(BaseResult result) {
        result = (result == null ? new BaseResult(null) : result);
        return JsonUtil.getJsonString(result);
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
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM));
    }

    /**
     * 异常
     *
     * @return
     */
    protected String buildExceptionJson() {
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.EXCEPTION));
    }

    /**
     * 操作失败
     *
     * @param failDesc
     * @return
     */
    protected String buildFailJson(String failDesc) {
        return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.FAIL.getCode(), failDesc));
    }

    /**
     * @return
     */
    protected String buildFailJson() {
        return buildFailJson(ResultCodeEnum.FAIL.getDesc());
    }

    /**
     * @param resultCodeEnum
     * @return
     */
    protected String buildFailJson(ResultCodeEnum resultCodeEnum) {
        return JsonUtil.getJsonString(new BaseResult(resultCodeEnum));
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
                baeResult = new BaseResult(ResultCodeEnum.SUCCESS);
        baeResult.setResultData(result);
        return JsonUtil.getJsonString(baeResult);
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    protected UserInfo getCurrentLoginUser(HttpServletRequest request) {
        String email = (String) request.getAttribute("accountId");
        if (StringUtils.isBlank(email)) {
            return null;
        }
        return userInfoService.getByEmail(email);
    }

    /**
     * 检查用户是否登录
     *
     * @return
     */
    protected boolean checkLogin(HttpServletRequest request) {
        return LoginUtil.checkLogin(request);
    }
}
