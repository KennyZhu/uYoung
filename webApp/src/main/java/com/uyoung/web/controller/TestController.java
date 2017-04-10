package com.uyoung.web.controller;

import com.uyoung.core.api.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

    public void test2(String email) {
        System.out.println("#ccccc");
    }
}
