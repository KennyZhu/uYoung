package com.uyoung.core.third.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

/**
 * Desc:
 * <p/>Date: 2015-11-17
 * <br/>Time: 16:54
 * <br/>User: ylzhu
 */
public final class QiNiuAccessTokenFactory {
    private static final QiNiuAccessTokenFactory INSTANCE = new QiNiuAccessTokenFactory();
    private Auth auth;

    private QiNiuAccessTokenFactory() {
        auth = Auth.create(QiNiuConstant.ACCESS_KEY, QiNiuConstant.SECRET_KEY);

    }

    public static QiNiuAccessTokenFactory getInstance() {
        return INSTANCE;
    }

    /**
     * 获取默认的上传凭证
     *
     * @return
     */
    public String getDefaultUpToken() {
        return auth.uploadToken(QiNiuConstant.DEFAULT_BUCKET);
    }

    /**
     * 获取指定上传凭证
     *
     * @return
     */
    private String getSpecialUpToken() {
        return auth.uploadToken(QiNiuConstant.DEFAULT_BUCKET, null, 3600, new StringMap()
                .put("callbackUrl", "call back url").putNotEmpty("callbackHost", "")
                .put("callbackBody", "key=$(key)&hash=$(etag)"));
    }


}
