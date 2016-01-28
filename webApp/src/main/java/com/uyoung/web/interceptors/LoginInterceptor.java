package com.uyoung.web.interceptors;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.Login;
import com.uyoung.web.enums.ResultCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Login login = LoginUtil.getLoginFromParam(request);
        if (login != null) {
            LOGGER.info("#Get Cookie return " + login.toString());
            boolean result = LoginUtil.checkLogin(login);
            if (result) {
                request.setAttribute("accountId", login.getAccountId());
                return true;
            }
        }
        LOGGER.warn("#No login found.");
        response.sendRedirect("/common/error?errorCode=" + ResultCodeEnum.NOT_LOGIN.getCode());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }
}
