package com.uyoung.web.vo;

import com.uyoung.core.api.model.ActivityInfo;

/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
public class ActivityInfoVo extends ActivityInfo {
    private String address;
    private String activityTypeDesc;
    private String statusDesc;
    private String feeTypeDesc;

    private int day;
    private int mon;
    private String weekDesc;
    private String fromTime;
    private String toTime;
    private String oriUserAvatarUrl;
    private String local;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMon() {
        return mon;
    }

    public void setMon(int mon) {
        this.mon = mon;
    }

    public String getWeekDesc() {
        return weekDesc;
    }

    public void setWeekDesc(String weekDesc) {
        this.weekDesc = weekDesc;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public String getOriUserAvatarUrl() {
        return oriUserAvatarUrl;
    }

    public void setOriUserAvatarUrl(String oriUserAvatarUrl) {
        this.oriUserAvatarUrl = oriUserAvatarUrl;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }


    public String getActivityTypeDesc() {
        return activityTypeDesc;
    }

    public void setActivityTypeDesc(String activityTypeDesc) {
        this.activityTypeDesc = activityTypeDesc;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    public String getFeeTypeDesc() {
        return feeTypeDesc;
    }

    public void setFeeTypeDesc(String feeTypeDesc) {
        this.feeTypeDesc = feeTypeDesc;
    }


    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
