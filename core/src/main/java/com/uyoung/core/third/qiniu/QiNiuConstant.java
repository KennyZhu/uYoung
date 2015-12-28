package com.uyoung.core.third.qiniu;

import org.apache.commons.lang.StringUtils;

/**
 * Desc:
 * <p/>Date: 2015-11-17
 * <br/>Time: 16:10
 * <br/>User: ylzhu
 */
public final class QiNiuConstant {
    public static final String ACCESS_KEY = "tq_GXB57qnS-yuR3Ci8ljH6qhcghtk51S-hkUJuS";
    public static final String SECRET_KEY = "1GPL8ts0TUNS1EUM3_AHpAnyws5VKtKhxL8zYTLo";
    /**
     * 图片空间
     */
    public static final String DEFAULT_BUCKET = "youngcommon";
    /**
     * 获取Token签名，加密Key
     */
    public static final String TOKEN_SIGN_KEY = "uYoungSign_QNToken";
    /**
     * 域名
     */
    public static final String URL_PREFIX = "http://7xnzko.com1.z0.glb.clouddn.com/";

    /**
     * 获取照片URL
     *
     * @param key
     * @return
     */
    public static String getUrl(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        return URL_PREFIX + key;
    }
}
