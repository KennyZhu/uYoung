package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
        List<ActivityInfo> activityInfoList = service.getPageByStatus(1, 10, statusEnum).getDataList();
        System.out.println("######" + activityInfoList.get(0).toString());
    }

    @Test
    public void getById() {
        int id = 1;
        LOGGER.info("##" + service.getById(id));
    }
}
