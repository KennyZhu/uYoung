package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.SessionDao;
import com.uyoung.core.api.model.Session;
import com.uyoung.core.api.service.SessionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * <p/>Date: 2015-12-07
 * <br/>Time: 18:02
 * <br/>User: ylzhu
 */
@Service("sessionService")
public class SessionServiceImpl implements SessionService {

    @Autowired
    private SessionDao sessionDao;

    @Override
    public int add(Session session) {
        if (session == null) {
            return 0;
        }
        return sessionDao.insert(session);
    }

    @Override
    public int deleteByUid(Integer uid) {
        if (uid == null) {
            return 0;
        }
        return sessionDao.deleteById(uid);
    }

    @Override
    public Session getByUidSessionId(Integer uid, String sessionId) {
        if (uid == null || StringUtils.isBlank(sessionId)) {
            return null;
        }
        return sessionDao.getByUidSessionId(uid, sessionId);
    }
}
