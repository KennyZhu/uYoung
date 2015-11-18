package com.uyoung.core.api.dao.impl;

import com.uyoung.core.api.dao.DictCityDao;
import com.uyoung.core.api.model.DictCity;
import com.uyoung.core.base.dao.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 11:47
 * <br/>User: ylzhu
 */
@Repository
public class DictCityDaoImpl extends BaseDao<DictCity> implements DictCityDao {

    @Override
    public int insert(DictCity dictCity) {
        return insert("insert", dictCity);
    }

    @Override
    public int updateByCnName(DictCity dictCity) {
        return update("updateByCnName", dictCity);
    }

    @Override
    public DictCity getByCnName(String cnName) {
        return selectOne("getByCnName", cnName);
    }

    @Override
    public List<DictCity> getListByIds(List<Integer> ids) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ids", ids);
        return selectList("getListByIds", paramMap);
    }
}
