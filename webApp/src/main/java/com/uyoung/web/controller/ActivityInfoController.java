package com.uyoung.web.controller;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.handler.ActivityInfoHandler;
import com.uyoung.web.util.JsonUtil;
import com.uyoung.web.vo.ActivityInfoVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc: 活动信息
 */
@Controller
public class ActivityInfoController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoController.class);

    @Autowired
    private ActivityInfoHandler activityInfoHandler;

    @Autowired
    private ActivityInfoService activityInfoService;

    @RequestMapping(value = "/activity/getPageByStatus")
    @ResponseBody
    public String getPageByStatus(Integer pageNum, Integer pageSize, Integer status, Integer uid) {
        if (pageNum == null || pageSize == null || ActivityStatusEnum.getByStatus(status) == null) {
            return buildInvalidParamJson();
        }
        Page<ActivityInfoVo> infoPage = activityInfoHandler.getPageByStatus(pageNum, pageSize, ActivityStatusEnum.getByStatus(status), uid);
        BaseResult baseResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
        baseResult.setResultData(infoPage);
        return JsonUtil.getJsonString(baseResult);
    }

    @RequestMapping(value = "/activity/getById")
    @ResponseBody
    public String getById(Integer id) {
        if (id == null) {
            return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));

        }
        ActivityInfoVo infoVo = activityInfoHandler.getActivityInfoById(id);
        BaseResult baseResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
        baseResult.setResultData(infoVo);
        return JsonUtil.getJsonString(baseResult);
    }

    @RequestMapping(value = "/activity/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            activityInfoService.add(activityInfo);
        } catch (Exception e) {
            LOGGER.error("#Add activity error!Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }
}
