package com.uyoung.core.api.service;

import com.uyoung.core.api.model.AlbumInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface AlbumInfoService {
    /**
     * 增加记录
     *
     * @param albumInfo
     * @return
     */
    public int add(AlbumInfo albumInfo);

    public AlbumInfo getById(int id);
}
