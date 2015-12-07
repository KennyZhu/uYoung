package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.Session;

/**
 * Desc:
 * <p/>Date: 2015-12-07
 * <br/>Time: 17:37
 * <br/>User: ylzhu
 */
public interface SessionDao {

    public Session getByUid(Integer uid);

    public Session getByUidSessionId(Integer uid, String sessionId);

    public int insert(Session session);

    public int deleteById(Integer id);

    public int updateStatusById(Integer id, Integer status);

}
