package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ThirdUser;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
public interface ThirdUserService {

    int add(ThirdUser thirdUser);

    ThirdUser getById(Integer id);
}
