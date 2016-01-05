package com.uyoung.core.api.service.impl;

import com.uyoung.core.api.dao.FeedBackDao;
import com.uyoung.core.api.model.FeedBack;
import com.uyoung.core.api.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Desc:
 * <p/>Date: 2016-01-05
 * <br/>Time: 10:44
 * <br/>User: ylzhu
 */
@Service
public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    private FeedBackDao feedBackDao;

    @Override
    public int insert(FeedBack feedBack) {
        if (feedBack == null) {
            return 0;
        }
        return feedBackDao.insert(feedBack);
    }
}
