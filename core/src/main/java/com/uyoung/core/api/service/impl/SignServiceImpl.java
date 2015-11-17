package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.service.SignService;
import com.uyoung.core.base.util.MD5Util;
import com.uyoung.core.third.qiniu.QiNiuConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * <p/>Date: 2015-11-17
 * <br/>Time: 17:23
 * <br/>User: ylzhu
 */
@Service("signService")
public class SignServiceImpl implements SignService {
    @Override
    public boolean checkQNTokenSign(long timestamp, String deviceId, String sign) {
        if (StringUtils.isBlank(deviceId) || StringUtils.isBlank(sign)) {
            return false;
        }
        if (sign.equals(getQNTokenSign(timestamp, deviceId))) {
            return true;
        }
        return false;
    }

    private String getQNTokenSign(long timestamp, String deviceId) {
        String sourceStr = deviceId + QiNiuConstant.TOKEN_SIGN_KEY + timestamp;
        return MD5Util.get(sourceStr, MD5Util.DEFAULT_ENCODE);
    }
}
