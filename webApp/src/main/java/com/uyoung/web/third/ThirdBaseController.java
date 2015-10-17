package com.uyoung.web.third;

import com.uyoung.core.base.service.HttpService;
import com.uyoung.core.third.bean.AuthParamBaseBean;
import com.uyoung.core.third.bean.DouBanAuthParamBean;
import com.uyoung.core.third.bean.WeiBoAuthParamBean;
import com.uyoung.core.third.enums.ThirdPlatformEnum;
import com.uyoung.web.bean.BaseResult;
import com.uyoung.web.enums.ResultCodeEnum;
import com.uyoung.web.util.JsonUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 16:25
 * <br/>User: ylzhu
 */
@Controller
public class ThirdBaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThirdBaseController.class);

    @Autowired
    private HttpService httpService;

    @RequestMapping(value = "/getCode")
    @ResponseBody
    public String getAuthCode(int thirdType, String redirectUrl, String stat, HttpServletRequest request, HttpServletResponse response) {
        if (ThirdPlatformEnum.getByCode(thirdType) == null || StringUtils.isBlank(redirectUrl)) {
            return JsonUtil.getJsonString(new BaseResult(ResultCodeEnum.INVALID_PARAM.getCode(), ResultCodeEnum.INVALID_PARAM.getDesc()));
        }
        try {
            AuthParamBaseBean authParamBaseBean = getAuthBeanByThirdType(thirdType);
            response.sendRedirect(authParamBaseBean.getThirdAuthUrl(redirectUrl));
        } catch (Exception e) {
            LOGGER.error("#", e);
        }
        return null;
    }

    @RequestMapping(value = "/getToken")
    @ResponseBody
    public String getAccessToken(String code, int thirdType, String redirectUrl, HttpServletResponse response) {
        try {
            LOGGER.info("#GetAccessToken code is " + code + " redirectUrl is " + redirectUrl);
            AuthParamBaseBean authParamBaseBean = getAuthBeanByThirdType(thirdType);
            String tokenUrl = authParamBaseBean.getThirdTokenUrl(redirectUrl, code);
            String accessTokeResult = httpService.sendPostRequest(tokenUrl);
            //TODO 登录之后的操作
            LOGGER.info("#AccessTokenResult is " + accessTokeResult);
            response.sendRedirect(redirectUrl);
        } catch (Exception e) {
            LOGGER.error("#", e);
        }
        return null;
    }

    private AuthParamBaseBean getAuthBeanByThirdType(int thirdType) {

        ThirdPlatformEnum thirdPlatform = ThirdPlatformEnum.getByCode(thirdType);

        if (thirdPlatform == null) {
            throw new IllegalArgumentException("Not sport thirdType.");
        }
        switch (thirdPlatform) {
            case DOUBAN:
                return new DouBanAuthParamBean();
            case WEIBO:
                return new WeiBoAuthParamBean();
            default:
                throw new IllegalArgumentException("Not sport thirdType.");
        }
    }
}
