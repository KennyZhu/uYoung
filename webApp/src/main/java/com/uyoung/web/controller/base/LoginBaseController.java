package com.uyoung.web.controller.base;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
@Controller
public class LoginBaseController extends BaseController {

    @Autowired
    private LoginService loginService;

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginBaseController.class);

    protected void login(HttpServletResponse response, String email, Integer uid) {
        try {
            LoginUtil.addLoginCookie(response, email, uid);
            Login login = LoginUtil.updateLogin(email, uid);
            loginService.add(login);
        } catch (Exception e) {
            LOGGER.error("#Login error.Cause:", e);
        }
    }
}
