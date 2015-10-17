package com.uyoung.core.third.bean;

/**
 * Desc:豆瓣授权接口参数Bean
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:46
 * <br/>User: ylzhu
 */
public class DouBanAuthParamBean extends AuthParamBaseBean {
    private static final String APP_KEY = "09cfe41f642337ee1d6fac5e2c69a7ca";
    private static final String APP_SECRET = "a0065d0702fdafef";
    private static final String AUTH_BASE_URL = "https://www.douban.com/service/auth2/auth?";
    private static final String TOKEN_BASE_URL = "https://www.douban.com/service/auth2/token?";
    private String stat;

    @Override
    public String getAppKey() {
        return APP_KEY;
    }

    @Override
    public String getAppSecret() {
        return APP_SECRET;
    }

    @Override
    public String getAuthBaseUrl() {
        return AUTH_BASE_URL;
    }

    @Override
    public String getTokenBaseUrl() {
        return TOKEN_BASE_URL;
    }
}
