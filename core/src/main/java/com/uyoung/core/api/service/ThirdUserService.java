package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.third.enums.ThirdPlatformEnum;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
public interface ThirdUserService {

    int add(ThirdUser thirdUser);

    ThirdUser getById(Integer id);

    ThirdUser getByThirdUid(String thirdUid, ThirdPlatformEnum thirdPlatform);

}
