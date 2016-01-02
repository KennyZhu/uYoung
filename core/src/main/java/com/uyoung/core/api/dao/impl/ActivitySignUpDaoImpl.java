package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.ActivitySignUpDao;
import com.uyoung.core.api.model.ActivitySignUp;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivitySignUpDaoImpl extends BaseDao<ActivitySignUp> implements ActivitySignUpDao {
    @Override
    public int insert(ActivitySignUp record) {
        return insert("insert", record);
    }

    @Override
    public ActivitySignUp getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateStatusByUidAid(Integer uid, Integer aid, int status) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("aid", aid);
        paramMap.put("status", status);
        return update("updateStatusByUidAid", paramMap);

    }

    @Override
    public List<ActivitySignUp> getListByActivityId(Integer aid) {
        return selectList("getListByActivityId", aid);
    }

    @Override
    public List<ActivitySignUp> getListByUidBeginTime(Integer uid, Date beginTime) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("beginTime", beginTime);
        return selectList("getListByUidBeginTime", paramMap);
    }

    @Override
    public ActivitySignUp getByAidUid(Integer aid, Integer uid) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("aid", aid);
        paramMap.put("uid", uid);
        return selectOne("getByAidUid", paramMap);
    }

    @Override
    public int deleteByUidAid(Integer uid, Integer aid) {
        Map<String, Integer> paraMap = new HashMap<>();
        paraMap.put("uid", uid);
        paraMap.put("aid", aid);
        return delete("deleteByUidAid", paraMap);
    }
}
