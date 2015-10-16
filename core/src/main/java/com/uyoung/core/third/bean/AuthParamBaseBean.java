package com.uyoung.core.third.bean;

/**
 * Desc:授权接口基本参数Bean
 * <p/>Date: 2015-10-16
 * <br/>Time: 18:45
 * <br/>User: ylzhu
 */
public class AuthParamBaseBean {
    private String clientId;
    private String redirectUri;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getRedirectUri() {
        return redirectUri;
    }

    public void setRedirectUri(String redirectUri) {
        this.redirectUri = redirectUri;
    }
}
