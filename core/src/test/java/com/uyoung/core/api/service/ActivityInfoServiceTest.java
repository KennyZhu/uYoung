package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.api.anno.parse.SortParser;
import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.enums.SortEnum;
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
        ActivityConditionBean conditionBean = new ActivityConditionBean();
        conditionBean.setStatus(ActivityStatusEnum.ACTIVE.getStatus());
        conditionBean.setBeginTimeSort(1);
        conditionBean.setSort(SortEnum.DESC.getValue());
        conditionBean.setSortColumn(SortParser.parser(conditionBean));

        LOGGER.info("#####" + conditionBean.toString());
        List<ActivityInfo> activityInfoList = service.getPageByCondition(conditionBean, 1, 10).getDataList();
        for (ActivityInfo activityInfo : activityInfoList) {
            System.out.println("######" + activityInfo.toString());
        }
    }

    @Test
    public void getById() {
        int id = 1;
        LOGGER.info("##" + service.getById(id));
    }
}
