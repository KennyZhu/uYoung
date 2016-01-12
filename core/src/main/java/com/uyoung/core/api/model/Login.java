package com.uyoung.core.api.model;

import com.uyoung.core.base.util.JsonUtil;

import java.util.Date;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public class Login {
    private Integer id;

    /**
     * 用户名称
     */
    private String accountId;

    /**
     * 一个Session中有效
     */
    private String loginToken;

    /**
     * 强制用户输入口令时更新（如：用户修改了口令）
     */
    private String loginHash;

    private Date createTime;

    private Date updateTime;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginHash() {
        return loginHash;
    }

    public void setLoginHash(String loginHash) {
        this.loginHash = loginHash;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBaseToString() {
        Login login = new Login();
        login.setAccountId(this.accountId);
        login.setLoginHash(this.loginHash);
        login.setLoginToken(this.loginToken);
        return JsonUtil.getJsonString(login);

    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", accountId='" + accountId + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", loginHash='" + loginHash + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
