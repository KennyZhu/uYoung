package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ThirdUser;

public interface ThirdUserDao {

    int insert(ThirdUser record);

    ThirdUser getByUid(Integer id);

    ThirdUser getByThirdUidUserType(String thirdUid, int userType);

    int updateByPrimaryKeySelective(ThirdUser record);

}