package com.uyoung.web.controller;

import com.uyoung.core.third.qiniu.QiNiuConstant;
import com.uyoung.core.third.qiniu.QiNiuStoreFactory;
import com.uyoung.web.controller.base.BaseController;
import com.uyoung.web.vo.QNCommonVo;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 17:30
 * <br/>User: ylzhu
 */
@Controller
public class QNController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(QNController.class);


    @RequestMapping(value = "/qn/qnUpToken", method = RequestMethod.POST)
    @ResponseBody
    public String getQNUpToken(String deviceId, String key) {
        if (StringUtils.isBlank(deviceId)) {
            return buildInvalidParamJson();
        }
        try {
            QNCommonVo commonVo = new QNCommonVo();
            commonVo.setUpToken(QiNiuStoreFactory.getInstance().getUpToken(key));
            commonVo.setUrl(QiNiuConstant.URL_PREFIX);
            return buildSuccessJson(commonVo);
        } catch (Exception e) {
            LOGGER.error("#Get QN upToken error.Cause:", e);
            return buildExceptionJson();
        }
    }
}
