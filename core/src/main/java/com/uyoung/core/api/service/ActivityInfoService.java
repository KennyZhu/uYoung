package com.uyoung.core.api.service;

import com.uyoung.core.api.model.ActivityInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivityInfoService {
    /**
     * @param activityInfo
     * @return
     */
    public int add(ActivityInfo activityInfo);

    /**
     * @param activityInfo
     * @return
     */
    public int updateById(ActivityInfo activityInfo);

}
