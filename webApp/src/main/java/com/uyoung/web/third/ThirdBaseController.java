package com.uyoung.web.third;

import com.uyoung.core.base.service.HttpService;
import com.uyoung.core.base.util.UrlEncodeUtil;
import com.uyoung.core.third.douban.constant.DouBanConstant;
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
    public String getAuthCode(String thirdType, String redirectUrl, String stat, HttpServletRequest request, HttpServletResponse response) {
        try {
            String getTokenUrl = "http://182.92.237.31/getToken?";
            if (StringUtils.isNotBlank(redirectUrl)) {
                getTokenUrl = getTokenUrl + "redirectUrl=" + UrlEncodeUtil.encodeUrl(redirectUrl, "UTF-8");
            }
            if (StringUtils.isNotBlank(stat)) {
                response.sendRedirect(DouBanConstant.getAuthUrl(stat, getTokenUrl));
            } else {
                response.sendRedirect(DouBanConstant.getAuthUrl(null, getTokenUrl));
            }
        } catch (Exception e) {
            LOGGER.error("#", e);
        }
        return null;
    }

    @RequestMapping(value = "/getToken")
    @ResponseBody
    public String getAccessToken(String code, String redirectUrl, HttpServletResponse response) {
        try {
            LOGGER.info("#GetAccessToken code is " + code + " redirectUrl is " + redirectUrl);
            String tokenUrl = DouBanConstant.getTokenUrl(redirectUrl, code);
            String accessTokeResult = httpService.sendPostRequest(tokenUrl);
            LOGGER.info("#AccessTokenResult is " + accessTokeResult);
            response.sendRedirect(redirectUrl);
        } catch (Exception e) {
            LOGGER.error("#", e);
        }
        return null;
    }
}
