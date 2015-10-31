package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.model.ThirdUser;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
public class ThirdUserServiceTest extends BaseTest {

    @Autowired
    private ThirdUserService service;


    @Test
    public void add() {
        ThirdUser thirdUser = new ThirdUser();

        thirdUser.setAccessToken("test");
        thirdUser.setAvatarUrl("http://www.baidu.com");
        thirdUser.setExpireIn(100000);
        thirdUser.setGender(1);
        thirdUser.setNickName("test");
        thirdUser.setThirdUid("thirduid");
        thirdUser.setUid(1);

        LOGGER.info("##Insert result is " + service.add(thirdUser));

    }
}
