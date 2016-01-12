package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.Login;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
public interface LoginDao {

    int insert(Login login);

    Login getByAccountId(String accountId);


}
