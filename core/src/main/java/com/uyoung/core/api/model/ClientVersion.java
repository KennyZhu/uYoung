package com.uyoung.core.api.model;

import java.util.Date;

/**
 * User: KennyZhu
 * Date: 16/1/8
 * Desc:客户端版本
 */
public class ClientVersion {
    private Integer id;
    /**
     * 版本号
     */
    private String version;
    /**
     * 客户端类型
     */
    private String clientType;
    /**
     * 审核状态
     */
    private Integer status;
    /**
     * 是否需要强制更新
     */
    private Integer isUpdate;
    /**
     * 更新内容
     */
    private String updateContent;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "ClientVersion{" +
                "id=" + id +
                ", version='" + version + '\'' +
                ", clientType='" + clientType + '\'' +
                ", status=" + status +
                ", isUpdate=" + isUpdate +
                ", updateContent='" + updateContent + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
