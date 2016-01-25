package com.uyoung.web.interceptors;

import com.uyoung.core.api.bean.BaseParamBean;
import com.uyoung.core.api.constant.CommonConstant;
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
    private static final Logger LOGGER = LoggerFactory.getLogger(EncryptionInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String data = request.getParameter(CommonConstant.PARAM_DATA);
        String stamp = request.getParameter(CommonConstant.PARAM_STAMP);
        if (StringUtils.isBlank(data) || StringUtils.isBlank(stamp)) {
            String msg = "加密接口没有传入密文,data=" + data + " stamp=" + stamp;
            LOGGER.error(msg);
            response.sendRedirect("/common/error?msg=" + msg);
            return false;
        }

        byte[] miyao = EncryptUtil.genCroptyKey(stamp);
        byte[] base = EncryptUtil.getFromBASE64(data);
        byte[] decodeBytes = EncryptUtil.decryptMode(miyao, base);

        String decodeStr = new String(decodeBytes, "utf-8");
        try {
            setParamIntoAction(decodeStr, request);
            BaseParamBean paramBean = new BaseParamBean();
            paramBean.setData(data);
            paramBean.setStamp(stamp);
            request.setAttribute(CommonConstant.PARAM_BEAN, paramBean);

        } catch (Exception e) {
            String msg = "加密拦截器设置value错误+decodeStr=" + decodeStr;
            LOGGER.error(msg);
            response.sendRedirect("/common/error?msg=" + msg);
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
