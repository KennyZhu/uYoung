package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.SessionDao;
import com.uyoung.core.api.model.Session;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * <p/>Date: 2015-12-07
 * <br/>Time: 17:37
 * <br/>User: ylzhu
 */
@Repository
public class SessionDaoImpl extends BaseDao<Session> implements SessionDao {
    @Override
    public int deleteById(Integer id) {
        return delete("deleteById", id);
    }

    @Override
    public int insert(Session session) {
        return insert("insert", session);
    }

    @Override
    public int updateStatusById(Integer id, Integer status) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("status", status);
        return update("updateStatusById", paramMap);
    }

    @Override
    public Session getByUid(Integer uid) {
        return selectOne("getByUid", uid);
    }

    @Override
    public Session getByUidSessionId(Integer uid, String sessionId) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("uid", uid);
        paramMap.put("sessionId", sessionId);
        return selectOne("getByUidSessionId", paramMap);
    }
}
