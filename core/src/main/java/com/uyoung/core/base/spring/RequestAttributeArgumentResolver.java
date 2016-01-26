package com.uyoung.core.base.spring;

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

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Annotation[] paramAnns = methodParameter.getParameterAnnotations();

        for (Annotation paramAnn : paramAnns) {
            if (RequestAttribute.class.isInstance(paramAnn)) {
                RequestAttribute reqAttr = (RequestAttribute) paramAnn;
                HttpServletRequest httpRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
                Object result = httpRequest.getAttribute(reqAttr.value());
                /**
                 * result 校验是否为null
                 　　*/
                return result;
            }
        }

        return WebArgumentResolver.UNRESOLVED;
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return true;
    }
}