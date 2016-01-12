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
@Service
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
}
