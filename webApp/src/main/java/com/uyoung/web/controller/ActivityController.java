package com.uyoung.web.controller;

import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.handler.ActivityInfoHandler;
import com.uyoung.web.vo.ActivityInfoVo;
import com.uyoung.web.vo.ActivityStatusVo;
import com.uyoung.web.vo.ActivityTypeVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc: 活动信息
 */
@Controller
public class ActivityController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityController.class);

    @Autowired
    private ActivityInfoHandler activityInfoHandler;

    @Autowired
    private ActivityInfoService activityInfoService;

    /**
     * 批量获取活动
     *
     * @param pageNum
     * @param pageSize
     * @param status
     * @param uid
     * @return
     */
    @RequestMapping(value = "/activity/getPageByStatus")
    @ResponseBody
    public String getPageByStatus(Integer pageNum, Integer pageSize, Integer status, Integer uid) {
        if (pageNum == null || pageSize == null || ActivityStatusEnum.getByStatus(status) == null) {
            return buildInvalidParamJson();
        }
        try {
            Page<ActivityInfoVo> infoPage = activityInfoHandler.getPageByStatus(pageNum, pageSize, ActivityStatusEnum.getByStatus(status), uid);
            return buildSuccessJson(infoPage);
        } catch (Exception e) {
            LOGGER.error("#Get page by status error.uid is :" + uid + " status is " + status + " Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 批量获取活动
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/activity/getPageByCondition")
    @ResponseBody
    public String getPageByCondition(Integer pageNum, Integer pageSize, ActivityConditionBean conditionBean) {
        LOGGER.info("#Begin to get page by condition");
        if (pageNum == null || pageSize == null) {
            return buildInvalidParamJson();
        }
        try {
            LOGGER.info("#Begin to get activity by condition " + conditionBean);
            Page<ActivityInfoVo> infoPage = activityInfoHandler.getPageByCondition(conditionBean, pageNum, pageSize);
            return buildSuccessJson(infoPage);
        } catch (Exception e) {
            LOGGER.error("#Get page by status error.Condition is :" + conditionBean + " Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 获取指定的活动
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/activity/getById")
    @ResponseBody
    public String getById(Integer id) {
        if (id == null) {
            return buildInvalidParamJson();
        }
        try {
            ActivityInfoVo infoVo = activityInfoHandler.getActivityInfoById(id);
            return buildSuccessJson(infoVo);
        } catch (Exception e) {
            LOGGER.error("#Get activity by id :" + id + " return error.Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 增加活动
     *
     * @param activityInfo
     * @return
     */
    @RequestMapping(value = "/activity/add", method = RequestMethod.POST)
    @ResponseBody
    public String add(ActivityInfo activityInfo) {
        if (activityInfo == null) {
            return buildInvalidParamJson();
        }
        try {
            activityInfoHandler.createActivity(activityInfo);
        } catch (Exception e) {
            LOGGER.error("#Add activity error!Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 取消活动
     *
     * @param activityId
     * @param uid
     * @return
     */
    @RequestMapping(value = "/activity/cal", method = RequestMethod.POST)
    @ResponseBody
    public String cal(Integer uid, Integer activityId) {
        if (uid == null || activityId == null) {
            return buildInvalidParamJson();
        }
        try {
            activityInfoService.cancel(uid, activityId);
        } catch (Exception e) {
            LOGGER.error("#Cal activity error!Uid is:" + uid + " activityId is " + activityId + "Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

    /**
     * 获取所有的活动类型
     *
     * @return
     */
    @RequestMapping(value = "/activity/types")
    @ResponseBody
    public String getTypes() {
        try {
            List<ActivityTypeVo> activityTypeVos = activityInfoHandler.getAllActivityTypes();
            return buildSuccessJson(activityTypeVos);
        } catch (Exception e) {
            LOGGER.error("#Add activity types error!Cause:", e);
            return buildExceptionJson();
        }
    }

    /**
     * 获取所有的活动类状态
     *
     * @return
     */
    @RequestMapping(value = "/activity/statuses")
    @ResponseBody
    public String getStatuses() {
        try {
            List<ActivityStatusVo> activityStatusVos = activityInfoHandler.getAllActivityStatus();
            return buildSuccessJson(activityStatusVos);
        } catch (Exception e) {
            LOGGER.error("#Add activity status error!Cause:", e);
            return buildExceptionJson();
        }
    }
}
