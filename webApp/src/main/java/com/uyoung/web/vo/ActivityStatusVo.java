package com.uyoung.web.vo;

import com.uyoung.core.api.enums.ActivityStatusEnum;

/**
 * Desc:
 * <p/>Date: 2015-12-15
 * <br/>Time: 11:46
 * <br/>User: ylzhu
 */
public class ActivityStatusVo {
    private int id;
    private String desc;


    public ActivityStatusVo() {
    }

    public ActivityStatusVo(ActivityStatusEnum statusEnum) {
        this.desc = statusEnum.getDesc();
        this.id = statusEnum.getStatus();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
