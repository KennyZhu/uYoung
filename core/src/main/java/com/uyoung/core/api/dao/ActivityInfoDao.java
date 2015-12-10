package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.base.bean.Page;

import java.util.List;

public interface ActivityInfoDao {

    int deleteById(Integer id);

    int insert(ActivityInfo record);

    ActivityInfo getById(Integer id);

    int updateById(ActivityInfo record);

    int updateByIdStatus(Integer id, Integer status);

    Page<ActivityInfo> getPageByStatus(int offset, int limit, int status, Integer oriUid);

    List<ActivityInfo> getListByIdList(List<Integer> idList);
}