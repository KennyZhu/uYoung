package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.bean.ActivityConditionBean;
import com.uyoung.core.api.dao.ActivityInfoDao;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.base.bean.Page;
import com.uyoung.core.base.dao.BaseDao;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
@Repository
public class ActivityInfoDaoImpl extends BaseDao<ActivityInfo> implements ActivityInfoDao {

    @Override
    public int deleteById(Integer id) {
        return delete("deleteById", id);
    }

    @Override
    public int insert(ActivityInfo record) {
        return insert("insert", record);
    }

    @Override
    public ActivityInfo getById(Integer id) {
        return selectOne("getById", id);
    }

    @Override
    public int updateById(ActivityInfo record) {
        return update("updateById", record);
    }

    @Override
    public Page<ActivityInfo> getPageByStatus(int offset, int limit, int status, Integer oriUid) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("status", status);
        paramMap.put("oriUid", oriUid);
        return selectPage("getPageByStatus", paramMap, new RowBounds(offset, limit));
    }

    @Override
    public int updateByIdStatus(Integer id, Integer status) {
        Map<String, Integer> paramMap = new HashMap<>();
        paramMap.put("id", id);
        paramMap.put("status", status);
        return update("updateByIdStatus", paramMap);
    }

    @Override
    public List<ActivityInfo> getListByIdList(List<Integer> idList) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("idList", idList);
        return selectList("getListByIdList", paramMap);
    }

    @Override
    public Page<ActivityInfo> getPageByCondition(ActivityConditionBean conditionBean, int offset, int limit) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("condition", conditionBean);
        return selectPage("getPageByCondition", paramMap, new RowBounds(offset, limit));
    }

    @Override
    public List<ActivityInfo> getListByStatusList(List<Integer> statusList) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("statusList", statusList);
        return selectList("getListByStatusList", paramMap);
    }
}
