package com.uyoung.core.third.bean;

/**
 * Desc:授权接口基本参数Bean
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:45
 * <br/>User: ylzhu
 */
public abstract class AuthParamBaseBean {
    /**
     * 授权链接
     */
    private String authUrl;
    private String clientId;
    private String appSecret;
    private String redirectUri;

    public abstract String getClientId();

    public abstract String getAppSecret();

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
