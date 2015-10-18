package com.uyoung.web;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.web.controller.ActivityInfoController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;

/**
 * User: KennyZhu
 * Date: 15/9/28
 * Desc:
 */
public class ActivityInfoControllerTest extends BaseControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityInfoControllerTest.class);

    @Test
    public void testLogin() throws IOException {
        ActivityInfoController controller = (ActivityInfoController) this.applicationContext.getBean("activityInfoController");
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("GET");
        int page = 1;
        int pageSize = 10;
        ActivityStatusEnum statusEnum = ActivityStatusEnum.ACTIVE;
        LOGGER.info("##" + controller.getPageByStatus(page, pageSize, statusEnum.getStatus(), null));
    }
}
