package com.uyoung.core.api.service;

import com.uyoung.core.api.model.DictCity;

import java.util.List;

/**
 * Desc:
 * <p/>Date: 2015-11-18
 * <br/>Time: 12:02
 * <br/>User: ylzhu
 */
public interface DictCityService {

    public void buildBaseData();

    public List<DictCity> getDictCityListByIds(List<Integer> ids);

    public List<DictCity> getDefaultCityList();

}
