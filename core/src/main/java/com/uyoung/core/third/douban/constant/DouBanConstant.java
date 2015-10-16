package com.uyoung.core.third.douban.constant;

import com.uyoung.core.api.constant.CommonConstant;
import com.uyoung.core.base.util.UrlEncodeUtil;
import org.apache.commons.lang.StringUtils;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 11:43
 * <br/>User: ylzhu
 */
public class DouBanConstant {
    public static final String APP_KEY = "09cfe41f642337ee1d6fac5e2c69a7ca";
    public static final String APP_SECRET = "a0065d0702fdafef";
    public static final String AUTH_BASE_URL = "https://www.douban.com/service/auth2/auth?";

    public static final String TOKEN_BASE_URL = "https://www.douban.com/service/auth2/token?";

    /**
     * 授权链接中必填参数
     */
    public static final String AUTH_RESPONSE_TYPE = "code";
    /**
     * 获取token时需要的grant_type 参数
     */
    public static final String TOKEN_GRANT_TYPE = "authorization_code";

    /**
     * 授权链接
     *
     * @param state
     * @return
     */
    public static String getAuthUrl(String state, String tokenUrl) {
        String url = AUTH_BASE_URL + "client_id=" + APP_KEY + "&response_type=" + AUTH_RESPONSE_TYPE + "&redirect_uri=" + UrlEncodeUtil.encodeUrl(tokenUrl, "UTF-8");
        if (StringUtils.isNotBlank(state)) {
            url = url + "&stat=" + UrlEncodeUtil.encodeUrl(state, CommonConstant.DEFAULT_ENCODE);
        }
        return url;

    }

    /**
     * 获取Token链接
     *
     * @param redirectUrl
     * @param authCode
     * @return
     */
    public static String getTokenUrl(String redirectUrl, String authCode) {
        String url = TOKEN_BASE_URL + "client_id=" + APP_KEY + "&client_secret=" + APP_SECRET + "&grant_type=" + TOKEN_GRANT_TYPE + "&code=" + authCode;
        if (StringUtils.isNotBlank(redirectUrl)) {
            url = url + "&redirect_uri=" + UrlEncodeUtil.encodeUrl(redirectUrl, "UTF-8");
        }
        return url;
    }
}
