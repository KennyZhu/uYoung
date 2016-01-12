package com.uyoung.web.controller.base;

import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
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

    protected void login(HttpServletResponse response, String accountId) {
        LoginUtil.addLoginCookie(response, accountId);
        Login login = LoginUtil.updateLogin(accountId);
        loginService.add(login);
    }
}
