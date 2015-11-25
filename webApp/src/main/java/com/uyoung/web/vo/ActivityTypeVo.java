package com.uyoung.web.vo;

import com.uyoung.core.api.enums.ActivityTypeEnum;

/**
 * Desc:
 * <p/>Date: 2015-11-25
 * <br/>Time: 16:51
 * <br/>User: ylzhu
 */
public class ActivityTypeVo {
    private int type;
    private String cnDesc;

    public ActivityTypeVo() {
    }

    public ActivityTypeVo(ActivityTypeEnum typeEnum) {
        if (typeEnum != null) {
            this.type = typeEnum.getType();
            this.cnDesc = typeEnum.getDesc();
        }
    }

    public String getCnDesc() {
        return cnDesc;
    }

    public void setCnDesc(String cnDesc) {
        this.cnDesc = cnDesc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
