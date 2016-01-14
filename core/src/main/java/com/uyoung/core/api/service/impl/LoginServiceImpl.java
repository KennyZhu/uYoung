package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.LoginDao;
import com.uyoung.core.api.model.Login;
import com.uyoung.core.api.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 16/1/12
 * Desc:
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDao loginDao;

    @Override
    public Login getByAccountId(String accountId) {
        if (StringUtils.isBlank(accountId)) {
            return null;
        }
        return loginDao.getByAccountId(accountId);
    }

    @Override
    public boolean add(Login login) {
        if (login == null) {
            return false;
        }
        return loginDao.insert(login) == 1;
    }

    @Override
    public boolean update(Login login) {
        if (login == null || StringUtils.isBlank(login.getAccountId())) {
            return false;
        }
        return loginDao.update(login) == 1;
    }

    @Override
    public boolean addOrUpdate(Login login) {
        if (login == null || StringUtils.isBlank(login.getAccountId())) {
            return false;
        }
        Login record = getByAccountId(login.getAccountId());
        if (record == null) {
            return add(login);
        } else {
            record.setLoginHash(login.getLoginHash());
            record.setLoginToken(login.getLoginToken());
            return update(login);
        }
    }
}
