package com.uyoung.core.api.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivitySignUp {

    private Integer id;

    private Integer activityId;

    private Integer userId;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public static void main(String[] args) throws Exception {
        String strDate1 = "2015-12-01 20:34:52";
        String strDate2 = "2015-11-30 20:34:52";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date date1 = simpleDateFormat.parse(strDate1);
        Date date2 = simpleDateFormat.parse(strDate2);
        Timestamp time1 = new Timestamp(date1.getTime());
        System.out.println(time1.after(date2));
    }
}