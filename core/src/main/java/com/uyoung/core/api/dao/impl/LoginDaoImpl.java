package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.LoginDao;
import com.uyoung.core.api.model.Login;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
@Repository
public class LoginDaoImpl extends BaseDao<Login> implements LoginDao {


    @Override
    public Login getByAccountId(String accountId) {
        return selectOne("getByAccountId", accountId);
    }

}
