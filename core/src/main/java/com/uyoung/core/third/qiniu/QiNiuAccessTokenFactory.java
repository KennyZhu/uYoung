package com.uyoung.core.third.qiniu;

import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang.StringUtils;

/**
 * Desc:七牛云存储处理
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
     * 获取指定Key的上传凭证
     *
     * @param key
     * @return
     */
    public String getUpToken(String key) {
        if (StringUtils.isBlank(key)) {
            return getDefaultUpToken();
        }
        return auth.uploadToken(QiNiuConstant.DEFAULT_BUCKET, key);
    }

    /**
     * 获取下载URL
     *
     * @param baseUrl
     * @return
     */
    public String getPrivateDownLoadUrl(String baseUrl) {
        if (StringUtils.isBlank(baseUrl)) {
            return null;
        }
        return auth.privateDownloadUrl(baseUrl);
    }

    /**
     * 获取照片的EXIF信息URL
     *
     * @param baseUrl
     * @return
     */
    public String getPrivateExifUrl(String baseUrl) {
        if (StringUtils.isBlank(baseUrl)) {
            return null;
        }
        baseUrl = baseUrl + "?exif";
        return getPrivateDownLoadUrl(baseUrl);
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
