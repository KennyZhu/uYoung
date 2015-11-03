package com.uyoung.web.interceptors;

import com.uyoung.core.base.util.EncryptUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;

/**
 * 加密拦截器
 */
public class EncryptionInterceptor extends HandlerInterceptorAdapter {
    private final byte[] ecodeStr =
            {(byte) 0xef, 0x2b, (byte) 0xcc, (byte) 0xdc, (byte) 0x9b, 0x3b, (byte) 0xf7, 0x2a, 0x68, (byte) 0xad, (byte) 0xeb,
                    0x72, (byte) 0xe3, 0x78, 0x2f, 0x5e, 0x7, 0x77, (byte) 0xd5, (byte) 0xc1, 0x7d, 0x40, 0x66, (byte) 0xb8};
    private final String APIVER = "apiVer";
    private final String DATA = "data";
    private final String STAMP = "stamp";
    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiVer = request.getParameter(APIVER);
        String data = request.getParameter(DATA);
        String stamp = request.getParameter(STAMP);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("apiVer=" + apiVer + " data=" + data + " stamp=" + stamp);
        }
        if (StringUtils.isBlank(data) || StringUtils.isBlank(stamp)) {
            LOGGER.info("加密接口没有传入密文,data" + data + " stamp=" + stamp);
            return false;
        }
        byte[] miyao = EncryptUtil.genCroptyKey(ecodeStr, stamp);
        byte[] base = EncryptUtil.getFromBASE64(data);

        byte[] decodeBytes = EncryptUtil.decryptMode(miyao, base);

        String decodeStr = new String(decodeBytes, "utf-8");
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("after url decode decodeStr=" + decodeStr);
        }
        try {
            setParamIntoAction(decodeStr, request);
            request.setAttribute("clientStamp", stamp);
        } catch (Exception e) {
            LOGGER.info("加密拦截器设置value错误+decodeStr=" + decodeStr);
            return false;
        }
        return true;
    }

    private void setParamIntoAction(String decodeStr, HttpServletRequest request) throws UnsupportedEncodingException {
        if (StringUtils.isNotBlank(decodeStr)) {
            String[] params = decodeStr.split("\\&");
            //验证参数是否符合规定的字符串
            for (String str : params) {
                String[] _pairs = str.split("\\=");
                if (_pairs.length == 2) {
                    request.setAttribute(_pairs[0], java.net.URLDecoder.decode(_pairs[1], "UTF-8"));
                }
            }

        } else {
            LOGGER.error("no param intercept decodeStr=" + decodeStr);
        }
    }
}
