package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ThirdUserDao;
import com.uyoung.core.api.model.ThirdUser;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * <p/>Date: 2015-10-30
 * <br/>Time: 18:27
 * <br/>User: ylzhu
 */
@Repository
public class ThirdUserDaoImpl extends BaseDao<ThirdUser> implements ThirdUserDao {

    @Override
    public int insert(ThirdUser record) {
        return insert("insert", record);
    }

    @Override
    public ThirdUser getByUid(Integer id) {
        return selectOne("getByUid", id);
    }

    @Override
    public ThirdUser getByThirdUidUserType(String thirdUid, int userType) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("thirdUid", thirdUid);
        paramMap.put("userType", userType);
        return selectOne("getByThirdUidUserType", paramMap);
    }

    @Override
    public int updateByPrimaryKeySelective(ThirdUser record) {
        return 0;
    }
}
