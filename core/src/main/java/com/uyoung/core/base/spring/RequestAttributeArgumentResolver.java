package com.uyoung.core.base.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

/**
 * Desc:实现解析Request 中Attribute中的参数
 * <p/>Date: 2016-01-26
 * <br/>Time: 11:43
 * <br/>User: ylzhu
 */
public class RequestAttributeArgumentResolver implements HandlerMethodArgumentResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestAttributeArgumentResolver.class);

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        LOGGER.info("#Begin to resolve Argument.");
        Annotation[] paramAnns = methodParameter.getParameterAnnotations();
        for (Annotation paramAnn : paramAnns) {
            if (RequestAttribute.class.isInstance(paramAnn)) {
                RequestAttribute reqAttr = (RequestAttribute) paramAnn;
                HttpServletRequest httpRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
                Object obj = httpRequest.getAttribute(reqAttr.value());
                LOGGER.info("#Resolve Argument:" + reqAttr.value());
                if (obj != null) {
                    return httpRequest.getAttribute(reqAttr.value());
                }
            }
        }

        return WebArgumentResolver.UNRESOLVED;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return true;
    }
}