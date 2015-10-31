package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.ThirdUserDao;
import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.api.service.ThirdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * User: KennyZhu
 * Date: 15/10/31
 * Desc:
 */
@Service
public class ThirdUserServiceImpl implements ThirdUserService {
    @Autowired
    private ThirdUserDao thirdUserDao;

    @Override
    public int add(ThirdUser thirdUser) {
        if (thirdUser == null) {
            return 0;
        }
        return thirdUserDao.insert(thirdUser);
    }

    @Override
    public ThirdUser getById(Integer id) {
        if (id == null) {
            return null;
        }
        return thirdUserDao.getByUid(id);
    }
}
