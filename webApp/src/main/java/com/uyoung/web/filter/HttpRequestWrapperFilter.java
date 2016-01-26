package com.uyoung.web.filter;

import com.uyoung.core.base.spring.HttpRequestWrapper;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Desc:
 * <p/>Date: 2016-01-26
 * <br/>Time: 16:48
 * <br/>User: ylzhu
 */
public class HttpRequestWrapperFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request = new HttpRequestWrapper((HttpServletRequest) request);
        chain.doFilter(request, response);
    }
}
