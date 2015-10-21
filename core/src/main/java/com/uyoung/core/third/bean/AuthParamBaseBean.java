package com.uyoung.core.third.bean;

import com.uyoung.core.base.util.UrlEncodeUtil;
import com.uyoung.core.third.enums.ThirdPlatformEnum;
import org.apache.commons.lang.StringUtils;

/**
 * Desc:授权接口基本参数Bean
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:45
 * <br/>User: ylzhu
 */
public abstract class AuthParamBaseBean {

    /**
     * 授权链接中必填参数
     */
    public static final String AUTH_RESPONSE_TYPE = "code";
    /**
     * 获取token时需要的grant_type 参数
     */
    public static final String TOKEN_GRANT_TYPE = "authorization_code";

    public abstract String getAppKey();

    public abstract String getAppSecret();

    public abstract String getAuthBaseUrl();

    public abstract String getTokenBaseUrl();

    public abstract ThirdPlatformEnum getThirdPlatform();

    /**
     * 获取第三方AuthCode URL
     *
     * @return
     */
    public String getThirdAuthUrl() {
        return getAuthBaseUrl() + "client_id=" + getAppKey() + "&response_type=" + AUTH_RESPONSE_TYPE + "&redirect_uri=" + UrlEncodeUtil.encodeUrl(getTokenUrl(getThirdPlatform()), "UTF-8");
    }

    /**
     * 获取第三方Token URL
     *
     * @param redirectUrl
     * @param authCode
     * @return
     */
    public String getThirdTokenUrl(String redirectUrl, String authCode) {
        String url = getTokenBaseUrl() + "client_id=" + getAppKey() + "&client_secret=" + getAppSecret() + "&grant_type=" + TOKEN_GRANT_TYPE + "&code=" + authCode;
        if (StringUtils.isNotBlank(redirectUrl)) {
            url = url + "&redirect_uri=" + UrlEncodeUtil.encodeUrl(redirectUrl, "UTF-8");
        }
        return url;
    }

    /**
     * 获取TokenUrl
     *
     * @return
     */
    public String getTokenUrl(ThirdPlatformEnum thirdPlatform) {
        return "http://182.92.237.31/getToken?thirdType=" + thirdPlatform.getCode();

    }
}
