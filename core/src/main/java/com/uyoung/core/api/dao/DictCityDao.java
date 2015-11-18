package com.uyoung.core.api.dao;

import com.uyoung.core.api.model.DictCity;

import java.util.List;

/**
 * Desc:城市字典
 * <p/>Date: 2015-11-18
 * <br/>Time: 11:46
 * <br/>User: ylzhu
 */
public interface DictCityDao {

    public int insert(DictCity dictCity);

    public int updateByCnName(DictCity dictCity);

    public DictCity getByCnName(String cnName);

    public List<DictCity> getListByIds(List<Integer> ids);
}
