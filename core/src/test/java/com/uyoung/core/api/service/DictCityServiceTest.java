package com.uyoung.core.api.service;

import com.uyoung.core.api.BaseTest;
import com.uyoung.core.base.util.JsonUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: KennyZhu
 * Date: 15/11/19
 * Desc:
 */
public class DictCityServiceTest extends BaseTest {

    @Autowired
    private DictCityService service;

    @Test
    public void getDefaultCity() {
        System.out.println(JsonUtil.getJsonString(service.getDefaultCityList()));
    }
}
