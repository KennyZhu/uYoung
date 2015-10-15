package com.uyoung.web.vo;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 17:59
 * <br/>User: ylzhu
 */
public class ActivityInfoDetailVo extends ActivityInfoVo {
    private int realNum;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRealNum() {
        return realNum;
    }

    public void setRealNum(int realNum) {
        this.realNum = realNum;
    }
}
