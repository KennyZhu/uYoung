package com.uyoung.core.api.service;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.api.model.ActivityInfo;
import com.uyoung.core.base.bean.Page;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface ActivityInfoService {

    /**
     * 分页获取活动信息
     *
     * @param pageNum    页码
     * @param pageSize   每页数量
     * @param statusEnum see {@link ActivityStatusEnum}
     * @return
     */
    public Page<ActivityInfo> getPageByStatus(int pageNum, int pageSize, ActivityStatusEnum statusEnum);

    /**
     * 获取详情
     *
     * @param id
     * @return
     */
    public ActivityInfo getById(int id);

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
