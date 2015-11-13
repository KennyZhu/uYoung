package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.base.bean.Page;

public interface ActivityInfoDao {

    int deleteById(Integer id);

    int insert(ActivityInfo record);

    ActivityInfo getById(Integer id);

    int updateById(ActivityInfo record);

    Page<ActivityInfo> getPageByStatus(int offset, int limit, int status, Integer oriUid);
}