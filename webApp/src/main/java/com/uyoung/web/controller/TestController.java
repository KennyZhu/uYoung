package com.uyoung.web.controller;

import com.uyoung.core.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.Future;

/**
 * desc
 * author yanlongzhu
 * date:2017/2/27.
 */
@Controller
public class TestController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public String doSth() {
        for (int i = 0; i < 90000; i++) {
            Future future = loginService.test();
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping(value = "/test2")
    @ResponseBody
    public String test2(String email) {
        loginService.test2();
        return null;
    }
}
