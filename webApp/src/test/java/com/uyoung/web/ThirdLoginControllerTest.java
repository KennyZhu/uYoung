package com.uyoung.web;

import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.web.third.ThirdLoginController;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
public class ThirdLoginControllerTest extends BaseControllerTest {
    @Test
    public void testLogin() throws IOException {
        ThirdLoginController controller = (ThirdLoginController) this.applicationContext.getBean("thirdLoginController");
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setMethod("POST");
        Map<String, Object> params = new HashMap<>();
        request.setParameters(params);

        ThirdUser thirdUser = new ThirdUser();
        thirdUser.setAccessToken("accessToken");
        thirdUser.setExpireIn(100000);
        thirdUser.setNickName("nickName");
        thirdUser.setAvatarUrl("avatarUrl");
        thirdUser.setGender(1);
        thirdUser.setThirdUid("12348971");
        thirdUser.setUserType(1);
        System.out.println("####" + controller.login(thirdUser));
    }
}
