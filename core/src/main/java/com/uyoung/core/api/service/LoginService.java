package com.uyoung.core.api.service;

import com.uyoung.core.api.model.Login;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public interface LoginService {

    boolean add(Login login);

    Login getByUid(Integer uid);

    boolean update(Login login);

    boolean addOrUpdate(Login login);
}
