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
    private Map<String, String[]> paramMap = new HashMap<>(super.getParameterMap());

    public HttpRequestWrapper(HttpServletRequest request) {
        super(request);
        this.paramMap.putAll(request.getParameterMap());
    }

    @Override
    public String[] getParameterValues(String name) {
        return paramMap.get(name);
    }

    public void addParam(String key, String value) {
        this.paramMap.put(key, new String[]{value});
    }

    @Override
    public String getParameter(String name) {//重写getParameter，代表参数从当前类中的map获取
        String[] values = paramMap.get(name);
        if (values == null || values.length == 0) {
            return null;
        }
        return values[0];
    }
}
