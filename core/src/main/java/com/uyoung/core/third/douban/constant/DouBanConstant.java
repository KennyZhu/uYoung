package com.uyoung.core.third.douban.constant;

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
     * @param redirectUrl 回调链接
     * @return
     */
    public static String getAuthUrl(String redirectUrl, String tokenUrl) {
        return AUTH_BASE_URL + "client_id=" + APP_KEY + "&redirect_uri=" + tokenUrl + "&response_type=" + AUTH_RESPONSE_TYPE + "&state=" + redirectUrl;

    }

    /**
     * 获取Token链接
     *
     * @param redirectUrl
     * @param authCode
     * @return
     */
    public static String getTokenUrl(String redirectUrl, String authCode) {
        return TOKEN_BASE_URL + "client_id=" + APP_KEY + "&client_secret=" + APP_SECRET + "&redirect_uri=" + redirectUrl + "&grant_type=" + TOKEN_GRANT_TYPE + "&code=" + authCode;

    }
}
