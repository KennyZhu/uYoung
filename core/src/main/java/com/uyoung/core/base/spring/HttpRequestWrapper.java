package com.uyoung.core.base.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * <p/>Date: 2016-01-26
 * <br/>Time: 16:49
 * <br/>User: ylzhu
 */
public class HttpRequestWrapper extends HttpServletRequestWrapper {
    private Map<String, Object> paramMap = new HashMap<>(super.getParameterMap());

    public HttpRequestWrapper(HttpServletRequest request) {
        super(request);
    }

    public void addParam(String key, Object obj) {
        this.paramMap.put(key, obj);
    }
}
