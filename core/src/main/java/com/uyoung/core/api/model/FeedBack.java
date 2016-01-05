package com.uyoung.core.api.model;

import java.util.Date;

/**
 * Desc:反馈
 * <p/>Date: 2016-01-04
 * <br/>Time: 18:00
 * <br/>User: ylzhu
 */
public class FeedBack {
    private Integer id;
    private String email;
    private String content;
    private Date createTime;
    private Date updateTime;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
