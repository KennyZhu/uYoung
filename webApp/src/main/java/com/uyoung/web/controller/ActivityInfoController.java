package com.uyoung.web.controller;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.handler.ActivityInfoHandler;
import com.uyoung.web.util.JsonUtil;
import com.uyoung.web.vo.ActivityInfoDetailVo;
import com.uyoung.web.vo.ActivityInfoVo;
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
public class ActivityInfoController {

    @Autowired
    private ActivityInfoHandler activityInfoHandler;

    @RequestMapping(value = "/activity/getPageByStatus")
    @ResponseBody
    public String getPageByStatus(Integer pageNum, Integer pageSize, Integer status) {
        if (pageNum == null || pageSize == null || ActivityStatusEnum.getByStatus(status) == null) {
            return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));
        }
        Page<ActivityInfoVo> infoPage = activityInfoHandler.getPageByStatus(pageNum, pageSize, ActivityStatusEnum.getByStatus(status));
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
        ActivityInfoDetailVo detailVo = activityInfoHandler.getActivityInfoDetailById(id);
        BaseResult baseResult = new BaseResult(ResultCodeEnum.SUCCESS.getCode(), ResultCodeEnum.SUCCESS.getDesc());
        baseResult.setResultData(detailVo);
        return JsonUtil.getJsonString(baseResult);
    }
}
