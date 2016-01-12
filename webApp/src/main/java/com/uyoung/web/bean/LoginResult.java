package com.uyoung.web.bean;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc: 登录返回结果
 */
public class LoginResult extends BaseResult {
    private Integer uid;
    private String sessionId;

    public LoginResult() {

    }

    public LoginResult(Integer uid, String sessionId) {
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
