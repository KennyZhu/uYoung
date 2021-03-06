package com.uyoung.web.controller.base;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.uyoung.core.api.constant.LoginUtil;
import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.Future;

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

    protected boolean login(HttpServletResponse response, String email, Integer uid) {
        if (response == null || StringUtils.isBlank(email) || uid == null) {
            return false;
        }
        try {
            Login login = LoginUtil.updateLogin(email, uid);
            Future future = test(email);
            future.get();
            LoginUtil.addLoginCookie(response, login);
            loginService.addOrUpdate(login);
            return true;
        } catch (Exception e) {
            LOGGER.error("#Login error.Cause:", e);
        }

        return false;
    }

    @HystrixCommand(fallbackMethod = "test2")
    public Future test(String email) {

        return new AsyncResult() {
            @Override
            public Object invoke() {
                throw new RuntimeException("Error");
            }
        };
    }

    @HystrixCommand
    public void test2(String email) {
        LOGGER.info("#Exception deal.");
    }
}
