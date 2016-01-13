package com.uyoung.core.third.qiniu;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Desc:七牛云存储处理
 * <p/>Date: 2015-11-17
 * <br/>Time: 16:54
 * <br/>User: ylzhu
 */
public final class QiNiuStoreFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(QiNiuStoreFactory.class);
    private static final QiNiuStoreFactory INSTANCE = new QiNiuStoreFactory();
    private Auth auth;
    private BucketManager bucketManager;

    private QiNiuStoreFactory() {
        auth = Auth.create(QiNiuConstant.ACCESS_KEY, QiNiuConstant.SECRET_KEY);
        bucketManager = new BucketManager(auth);

    }

    public static QiNiuStoreFactory getInstance() {
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
     * 删除单个Key的照片
     *
     * @param key
     * @return
     */
    public boolean del(String key) {

        try {
            bucketManager.delete(QiNiuConstant.DEFAULT_BUCKET, key);
            return true;
        } catch (Exception e) {
            LOGGER.error("#Delete key:" + key + " from QN error.Cause:", e);
        }

        return false;
    }

    /**
     * 批量删除
     *
     * @param keys
     * @return
     */
    public boolean batchDel(List<String> keys) {
        BucketManager.Batch ops = new BucketManager.Batch();
        for (String key : keys) {
            ops = batchDel(ops, key);
        }

        try {
            Response r = bucketManager.batch(ops);
            r.jsonToObject(BatchStatus[].class);
            return true;

        } catch (QiniuException e) {
            Response r = e.response;
            // 请求失败时简单状态信息
            LOGGER.error(r.toString());
            try {
                // 响应的文本信息
                LOGGER.error(r.bodyString());
            } catch (QiniuException e1) {
                LOGGER.error("#" + e1);
            }
        }
        return false;

    }

    private BucketManager.Batch batchDel(BucketManager.Batch ops, String key) {
        return ops.delete(QiNiuConstant.DEFAULT_BUCKET, key);
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
