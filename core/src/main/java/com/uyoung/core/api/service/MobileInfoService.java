package com.uyoung.core.api.service;

import com.uyoung.core.api.model.MobileInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface MobileInfoService {

    public int add(MobileInfo mobileInfo);

    public MobileInfo getById(int id);
}
