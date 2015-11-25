package com.uyoung.web;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.web.controller.AlbumInfoController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.IOException;

/**
 * Desc:
 * <p/>Date: 2015-10-20
 * <br/>Time: 18:22
 * <br/>User: ylzhu
 */
public class AlbumInfoControllerTest extends BaseControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(ActivityControllerTest.class);

    @Test
    public void testLogin() throws IOException {
        AlbumInfoController controller = (AlbumInfoController) this.applicationContext.getBean("albumInfoController");
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setMethod("GET");
        int page = 1;
        int pageSize = 10;
        ActivityStatusEnum statusEnum = ActivityStatusEnum.ACTIVE;
        LOGGER.info("##" + controller.getByUid(1, 1, 10));
    }
}
