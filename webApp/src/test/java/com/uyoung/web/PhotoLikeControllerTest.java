package com.uyoung.web;

import com.uyoung.web.controller.PhotoLikeController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Desc:
 * <p/>Date: 2015-11-10
 * <br/>Time: 16:54
 * <br/>User: ylzhu
 */
public class PhotoLikeControllerTest extends BaseControllerTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoLikeControllerTest.class);

    @Test
    public void like() throws IOException {
        PhotoLikeController controller = (PhotoLikeController) this.applicationContext.getBean("photoLikeController");
//        MockHttpServletRequest request = new MockHttpServletRequest();
//        request.setMethod("GET");
        LOGGER.info(controller.unlike(1, 1));
    }
}
