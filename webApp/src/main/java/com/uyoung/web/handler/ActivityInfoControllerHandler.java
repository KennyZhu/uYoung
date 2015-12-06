package com.uyoung.web.handler;

import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.api.service.ActivityInfoService;
import com.uyoung.core.api.service.ActivitySignUpService;
import com.uyoung.web.vo.ActivityInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 18:54
 * <br/>User: ylzhu
 */
@Service
public class ActivityInfoControllerHandler {
    @Autowired
    private ActivityInfoService activityInfoService;

    @Autowired
    private ActivitySignUpService signUpService;

    public ActivityInfoVo getActivityInfoDetailById(int id) {
        ActivityInfo info = activityInfoService.getById(id);
        if (info == null) {
            return null;
        }
        return new ActivityInfoVoBuilder(info).buildBase().buildDetail().buildOriUserInfo().getInfoVo();
    }


}
