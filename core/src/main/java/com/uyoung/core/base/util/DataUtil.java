package com.uyoung.core.base.util;

import com.uyoung.core.api.constant.CommonConstant;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;

import java.net.URLDecoder;
import java.util.Collections;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 16/1/23
 * Desc:
 */
public final class DataUtil {
    private DataUtil() {

    }

    /**
     * 参数字符串中解析参数对
     *
     * @param paramStr
     * @return
     */
    public static Map<String, String> parseParamStr(String paramStr) {
        if (StringUtils.isBlank(paramStr)) {
            return Collections.emptyMap();
        }
        Map<String, String> result = new HashedMap();


        try {
            String[] params = paramStr.split("\\&");
            //验证参数是否符合规定的字符串
            for (String str : params) {
                String[] _pairs = str.split("\\=");
                if (_pairs.length == 2) {
                    result.put(_pairs[0], URLDecoder.decode(_pairs[1], CommonConstant.DEFAULT_ENCODE));
                }
            }
            return result;
        } catch (Exception e) {
            return Collections.emptyMap();
        }

    }
}
