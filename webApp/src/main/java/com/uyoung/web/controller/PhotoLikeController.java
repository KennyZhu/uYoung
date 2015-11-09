package com.uyoung.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Desc:照片点赞
 * <p/>Date: 2015-11-09
 * <br/>Time: 11:55
 * <br/>User: ylzhu
 */
@Controller
public class PhotoLikeController extends BaseController {

    @RequestMapping(value = "/photoLike/like")
    public String like(Integer uid, Integer photoId) {
        if (uid == null || photoId == null) {
            return buildInvalidParamJson();
        }
    }
}
