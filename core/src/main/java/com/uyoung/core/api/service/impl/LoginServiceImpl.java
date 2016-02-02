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
    public Login getByUid(Integer uid) {
        if (uid == null) {
            return null;
        }
        return loginDao.getByUid(uid);
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
        if (login == null || StringUtils.isBlank(login.getEmail())) {
            return false;
        }

        return loginDao.update(login) == 1;
    }

    @Override
    public boolean addOrUpdate(Login login) {
        if (login == null || login.getUid() == null) {
            return false;
        }
        Login record = getByUid(login.getUid());
        if (record == null) {
            return add(login);
        } else {
            record.setLoginHash(login.getLoginHash());
            record.setLoginToken(login.getLoginToken());
            return update(login);
        }
    }
}
