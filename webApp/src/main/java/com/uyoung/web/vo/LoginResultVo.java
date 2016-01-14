package com.uyoung.web.vo;

/**
 * Desc:
 * <p/>Date: 2016-01-14
 * <br/>Time: 15:52
 * <br/>User: ylzhu
 */
public class LoginResultVo {
    private Integer uid;
    private String sessionId;

    public LoginResultVo() {

    }

    public LoginResultVo(Integer uid, String sessionId) {
        this.uid = uid;
        this.sessionId = sessionId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}
