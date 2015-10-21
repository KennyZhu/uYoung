package com.uyoung.core.third.bean;

import com.uyoung.core.third.enums.ThirdPlatformEnum;

/**
 * Desc:
 * <p/>Date: 2015-10-21
 * <br/>Time: 18:13
 * <br/>User: ylzhu
 */
public class QQAuthParamBean extends AuthParamBaseBean {
    private static final String APP_KEY = "1104920700";
    private static final String APP_SECRET = "KNuxx0WvgGddPBq6";
    private static final String AUTH_BASE_URL = "https://graph.z.qq.com/moc2/authorize?";
    private static final String TOKEN_BASE_URL = "https://graph.z.qq.com/moc2/token?";

    public QQAuthParamBean() {
        this.stat = "";
    }

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

    @Override
    public ThirdPlatformEnum getThirdPlatform() {
        return ThirdPlatformEnum.QQ;
    }
}
