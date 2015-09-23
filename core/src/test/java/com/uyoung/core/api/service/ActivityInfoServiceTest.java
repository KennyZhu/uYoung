package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public class ActivityInfoServiceTest extends BaseTest {
    @Autowired
    private ActivityInfoService service;

    @Test
    public void getPageByStatus() {
        ActivityStatusEnum statusEnum = ActivityStatusEnum.ACTIVE;
        System.out.println(service.getListByStatus(1, 10, statusEnum));
    }
}
