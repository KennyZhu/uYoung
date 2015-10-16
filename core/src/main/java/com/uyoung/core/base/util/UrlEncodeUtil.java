package com.uyoung.core.base.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Desc:
 * <p/>Date: 2015-10-16
 * <br/>Time: 17:18
 * <br/>User: ylzhu
 */
public final class UrlEncodeUtil {
    private UrlEncodeUtil() {
    }

    private static final char[] bcdLookup =
            {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /**
     * 将字符数组转换为16进制字符串
     *
     * @param bcd
     * @return
     */
    public static final String bytesToHexStr(byte[] bcd) {
        StringBuffer s = new StringBuffer(bcd.length * 2);

        for (int i = 0; i < bcd.length; i++) {
            s.append(bcdLookup[(bcd[i] >>> 4) & 0x0f]);
            s.append(bcdLookup[bcd[i] & 0x0f]);
        }

        return s.toString();
    }

    /**
     * 将16进制字符串转换为字符数组
     *
     * @param source
     * @return
     */
    public static final byte[] hexStrToBytes(String source) {
        byte[] bytes;

        bytes = new byte[source.length() / 2];

        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(source.substring(2 * i, 2 * i + 2), 16);
        }

        return bytes;
    }

    @SuppressWarnings("deprecation")
    public static String encodeUrl(String url, String charsetName) {
        String urlAfterEncode = "";
        try {
            urlAfterEncode = URLEncoder.encode(url, charsetName);
        } catch (UnsupportedEncodingException e) {
            urlAfterEncode = URLEncoder.encode(url);
        }
        return urlAfterEncode;
    }

    @SuppressWarnings("deprecation")
    public static String decodeUrl(String url, String charsetName) {
        String urlAfterDecode = "";
        try {
            urlAfterDecode = URLDecoder.decode(url, charsetName);
        } catch (UnsupportedEncodingException e) {
            urlAfterDecode = URLDecoder.decode(url);
        }
        return urlAfterDecode;
    }

    /**
     * URL 编码
     */
    public static String urlEncode(String input, String encoding) {
        try {
            return URLEncoder.encode(input, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("Unsupported Encoding Exception", e);
        }
    }

    /**
     * Base64编码
     */
    public static String base64Encode(byte[] input) {
        return Base64.encodeS(input);
    }
}
