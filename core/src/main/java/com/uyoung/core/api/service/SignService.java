package com.uyoung.core.api.service;

/**
 * Desc:
 * <p/>Date: 2015-11-17
 * <br/>Time: 17:23
 * <br/>User: ylzhu
 */
public interface SignService {

    /**
     * QiNiu UpdateToken 签名验证
     *
     * @param timestamp
     * @param deviceId
     * @param sign
     * @return
     */
    public boolean checkQNTokenSign(long timestamp, String deviceId, String sign);
}
