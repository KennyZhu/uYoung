package com.uyoung.web.service;

import com.uyoung.core.api.enums.ActivityStatusEnum;
import com.uyoung.core.base.bean.Page;
import com.uyoung.web.vo.ActivityInfoVo;

/**
 * User: KennyZhu
 * Date: 15/10/12
 * Desc:
 */
public interface ActivityInfoListService {
    Page<ActivityInfoVo> getPageByStatus(ActivityStatusEnum statusEnum, int page, int pageSize);
}
