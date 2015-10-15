package com.uyoung.core.third.bean;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 12:13
 * <br/>User: ylzhu
 */
public class AccessToken {

    private String accessToken;

    /**
     * 过期时间
     */
    private long expireIn;

    private String uid;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(long expireIn) {
        this.expireIn = expireIn;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
