package com.uyoung.core.base.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.Map;

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
        Class<?> paramType = methodParameter.getParameterType();

        String[] args = nativeWebRequest.getAttributeNames(RequestAttributes.SCOPE_REQUEST);
        MultiValueMap<String, Object> result = new LinkedMultiValueMap<String, Object>(args.length);
        for (String key : args) {
            result.add(key, nativeWebRequest.getAttribute(key, RequestAttributes.SCOPE_REQUEST));
        }
        return result;
    }


//        LOGGER.info("#Begin to resolve Argument.");
//        Class<?> paramType = methodParameter.getParameterType();
//        Annotation[] paramAnns = methodParameter.getParameterAnnotations();
//        for (Annotation paramAnn : paramAnns) {
//            if (RequestAttribute.class.isInstance(paramAnn)) {
//                RequestAttribute reqAttr = (RequestAttribute) paramAnn;
//                HttpServletRequest httpRequest = (HttpServletRequest) nativeWebRequest.getNativeRequest();
//                Object obj = httpRequest.getAttribute(reqAttr.value());
//                LOGGER.info("#Resolve Argument:" + reqAttr.value());
//                if (obj != null) {
//                    return httpRequest.getAttribute(reqAttr.value());
//                }
//            }
//        }
//
//        return WebArgumentResolver.UNRESOLVED;

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        RequestAttribute requestParam = methodParameter.getParameterAnnotation(RequestAttribute.class);
        if (requestParam != null) {
            if (Map.class.isAssignableFrom(methodParameter.getParameterType())) {
                return !StringUtils.hasText(requestParam.value());
            }
        }
        return false;
    }
}