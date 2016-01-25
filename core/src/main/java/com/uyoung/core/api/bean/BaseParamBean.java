package com.uyoung.core.api.bean;

/**
 * User: KennyZhu
 * Date: 16/1/23
 * Desc:
 */
public class BaseParamBean {
    /**
     * 客户端类型
     */
    private String clientType;

    /**
     * SessionId
     */
    private String sessionId;
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

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public String toString() {
        return "BaseParamBean{" +
                "apiVer='" + apiVer + '\'' +
                ", clientType='" + clientType + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", data='" + data + '\'' +
                ", stamp='" + stamp + '\'' +
                '}';
    }
}
