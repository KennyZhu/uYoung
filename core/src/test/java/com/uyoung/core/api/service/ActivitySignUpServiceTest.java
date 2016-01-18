package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.enums.ActivitySignUpStatusEnum;
import com.uyoung.core.api.model.ActivitySignUp;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 18:47
 * <br/>User: ylzhu
 */
public class ActivitySignUpServiceTest extends BaseTest {
    @Autowired
    private ActivitySignUpService service;

    @Test
    public void getPageByUid() {
        LOGGER.info("####" + service.getListByActivityId(1));
    }

    @Test
    public void insert() {
        ActivitySignUp signUp = new ActivitySignUp();
        signUp.setActivityId(1);
        signUp.setStatus(1);
        signUp.setUserId(1);
        service.add(signUp);

        ActivitySignUp signUp1 = new ActivitySignUp();
        signUp1.setActivityId(1);
        signUp1.setStatus(1);
        signUp1.setUserId(1);
        service.add(signUp);
    }

    @Test
    public void updateStatus() {
        Integer uid = 23;
        Integer aid = 53;
        LOGGER.info("Update :" + service.updateStatusByUidAid(uid, aid, ActivitySignUpStatusEnum.CONFIRM));
    }
}
