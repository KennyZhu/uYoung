package com.uyoung.web.controller;

import com.uyoung.core.api.enums.ClientStatusEnum;
import com.uyoung.core.api.enums.ClientTypeEnum;
import com.uyoung.core.api.model.ClientVersion;
import com.uyoung.core.api.model.FeedBack;
import com.uyoung.core.api.service.ClientVersionService;
import com.uyoung.core.api.service.DictCityService;
import com.uyoung.core.api.service.FeedBackService;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.enums.ResultCodeEnum;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:通用功能 所有功能不需要登录
 * <p/>Date: 2015-11-17
 * <br/>Time: 17:20
 * <br/>User: ylzhu
 */
@Controller
public class CommonController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private DictCityService dictCityService;

    @Autowired
    private FeedBackService feedBackService;

    @Autowired
    private ClientVersionService clientVersionService;


    @RequestMapping(value = "/common/cities", method = RequestMethod.POST)
    @ResponseBody
    public String getCityDict(String deviceId) {
        if (StringUtils.isBlank(deviceId)) {
            return buildInvalidParamJson();
        }
        try {
            return buildSuccessJson(dictCityService.getDefaultCityList());
        } catch (Exception e) {
            LOGGER.error("#Get City Dict error.Cause:", e);
            return buildExceptionJson();
        }
    }

    @RequestMapping(value = "/common/error")
    @ResponseBody
    public String invalidParam(String msg, Integer errorCode) {
        if (ResultCodeEnum.NOT_LOGIN.getCode() == errorCode) {
            return buildFailJson(ResultCodeEnum.NOT_LOGIN);
        }
        return buildFailJson(msg);

    }

    /**
     * 判断版本审核状态
     *
     * @param version
     * @return
     */
    @RequestMapping(value = "/common/clientAudit")
    @ResponseBody
    public String getAuditStatus(String version, String sign) {
        if (StringUtils.isBlank(version)) {
            return buildInvalidParamJson();
        }

        ClientVersion clientVersion = clientVersionService.getByVersion(version);
        if (clientVersion == null) {
            return buildFailJson("No client version found");
        }
        if (ClientStatusEnum.AUDITED == ClientStatusEnum.getByStatus(clientVersion.getStatus())) {
            return buildSuccessJson(true);
        }
        return buildSuccessJson(false);

    }

    /**
     * 获取最新的审核通过的版本
     *
     * @return
     */
    @RequestMapping(value = "/common/getLastClient")
    @ResponseBody
    public String getLastAuditClient(Integer clientType) {
        if (clientType == null || ClientTypeEnum.getByType(clientType) == null) {
            return buildInvalidParamJson();
        }
        try {
            ClientTypeEnum clientTypeEnum = ClientTypeEnum.getByType(clientType);
            ClientVersion clientVersion = clientVersionService.getLastVersion(clientTypeEnum);
            return buildSuccessJson(clientVersion);
        } catch (Exception e) {
            return buildExceptionJson();
        }
    }


    @RequestMapping(value = "/common/feedBack", method = RequestMethod.POST)
    @ResponseBody
    public String feedBack(FeedBack feedBack) {
        if (feedBack == null || StringUtils.isBlank(feedBack.getEmail()) || StringUtils.isBlank(feedBack.getContent())) {
            buildInvalidParamJson();
        }
        try {
            feedBackService.insert(feedBack);
        } catch (Exception e) {
            LOGGER.error("#Add feedBack error.Cause:", e);
            return buildExceptionJson();
        }
        return buildSuccessJson();
    }

}
