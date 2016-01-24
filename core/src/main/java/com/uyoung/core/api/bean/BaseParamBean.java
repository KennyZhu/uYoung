package com.uyoung.core.api.bean;

/**
 * User: KennyZhu
 * Date: 16/1/23
 * Desc:
 */
public class BaseParamBean {
    /**
     * 客户端版本
     */
    private String apiVer;

    /**
     * 加密参数
     */
    private String data;

    /**
     * 时间戳
     */
    private String stamp;

    public String getApiVer() {
        return apiVer;
    }

    public void setApiVer(String apiVer) {
        this.apiVer = apiVer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp;
    }
}
