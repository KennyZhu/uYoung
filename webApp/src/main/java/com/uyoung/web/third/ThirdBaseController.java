package com.uyoung.web.third;

import com.uyoung.core.base.service.HttpService;
import com.uyoung.core.third.douban.constant.DouBanConstant;
import org.apache.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public String getAuthCode(String thirdType, HttpRequest request, HttpResponse response) {
        httpService.sendGetRequest(DouBanConstant.getAuthUrl("/getToken", "http://www.baidu.com"));
        return null;
    }

    @RequestMapping(value = "/getToken")
    @ResponseBody
    public String getAccessToken(String code, String redirectUrl) {
        String tokenUrl = DouBanConstant.getTokenUrl(redirectUrl, code);
        String accessTokeResult = httpService.sendPostRequest(tokenUrl);
        LOGGER.info("#AccessTokenResult is " + accessTokeResult);
        return null;
    }
}
