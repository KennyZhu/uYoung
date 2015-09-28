package com.uyoung.web.controller;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
@Controller
public class ActivityInfoController extends BaseController {

    @Autowired
    private ActivityInfoService activityInfoService;

    @RequestMapping(value = "/activity/getPageByStatus")
    @ResponseBody
    public String getPageByStatus(int pageNum, int pageSize, int status) {
        if (pageNum <= 0 || pageSize <= 0 || ActivityStatusEnum.getByStatus(status) == null) {
            return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));
        }
        Page<ActivityInfo> infoPage = activityInfoService.getPageByStatus(pageNum, pageSize, ActivityStatusEnum.getByStatus(status));
        BaseResult baseResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getDesc());
        baseResult.setResultData(infoPage);
        return JsonUtil.getJsonString(baseResult);
    }
}
