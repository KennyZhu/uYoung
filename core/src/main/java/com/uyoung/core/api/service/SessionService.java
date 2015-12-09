package com.uyoung.core.api.service;

import com.uyoung.core.api.model.Session;

/**
 * Desc:
 * <p/>Date: 2015-12-07
 * <br/>Time: 18:01
 * <br/>User: ylzhu
 */
public interface SessionService {

    /**
     * @param session
     * @return
     */
    public int add(Session session);

    /**
     * @param uid
     * @return
     */
    public int deleteByUid(Integer uid);


    /**
     * @param uid
     * @param sessionId
     * @return
     */
    public Session getByUidSessionId(Integer uid, String sessionId);
}
