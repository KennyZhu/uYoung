package com.uyoung.web.controller;

import com.uyoung.web.controller.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: KennyZhu
 * Date: 16/3/27
 * Desc:
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping(value = "/index.html")
    public String index() {
        return "index";
    }
}
