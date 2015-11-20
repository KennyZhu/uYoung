package com.uyoung.core.api.model;

import java.util.Date;

public class ActivityInfo {

    private Integer id;

    private String title;

    private Integer oriUserId;

    private Date beginTime;

    private Date endTime;

    private String address;

    private Integer needNum;

    private Integer realNum;

    private int activityType;

    private int feeType;

    private String description;

    private int status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOriUserId() {
        return oriUserId;
    }

    public void setOriUserId(Integer oriUserId) {
        this.oriUserId = oriUserId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNeedNum() {
        return needNum;
    }


    public void setNeedNum(Integer needNum) {
        this.needNum = needNum;
    }

    public Integer getRealNum() {
        return realNum;
    }


    public void setRealNum(Integer realNum) {
        this.realNum = realNum;
    }


    public int getActivityType() {
        return activityType;
    }

    public void setActivityType(int activityType) {
        this.activityType = activityType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getFeeType() {
        return feeType;
    }

    public void setFeeType(int feeType) {
        this.feeType = feeType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public static void main(String[] args) {
        try {
            badMethod();
            System.out.println("1");
        } catch (RuntimeException e) {
            System.out.println("2");
        } finally {
            System.out.println("3");
        }
        System.out.println("4");
    }

    public static void badMethod() {
        throw new NullPointerException();
    }
    @Override
    public String toString() {
        return "ActivityInfo{" +
                "activityType=" + activityType +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", oriUserId=" + oriUserId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", address='" + address + '\'' +
                ", needNum=" + needNum +
                ", realNum=" + realNum +
                ", feeType=" + feeType +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}