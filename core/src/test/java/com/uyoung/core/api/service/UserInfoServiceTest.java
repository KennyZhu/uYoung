package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Desc:
 * <p/>Date: 2015-10-15
 * <br/>Time: 17:40
 * <br/>User: ylzhu
 */
public class UserInfoServiceTest extends BaseTest {
    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void getById() {
        int id = 1;
        LOGGER.info("##" + userInfoService.getById(id));
    }
}
