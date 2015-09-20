package com.uyoung.core.api.service;

import com.uyoung.core.api.model.PhotoInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface PhotoInfoService {

    public int add(PhotoInfo photoInfo);

    public PhotoInfo getById(int id);

    public int updateById(PhotoInfo photoInfo);

}
