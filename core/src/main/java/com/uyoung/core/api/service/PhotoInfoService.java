package com.uyoung.core.api.service;

import com.uyoung.core.api.model.PhotoInfo;

/**
 * User: KennyZhu
 * Date: 15/9/20
 * Desc:
 */
public interface PhotoInfoService {

    /**
     * @param photoInfo
     * @return
     */
    public int add(PhotoInfo photoInfo);

    /**
     * @param id
     * @return
     */
    public PhotoInfo getById(Integer id);

    /**
     * @param photoInfo
     * @return
     */
    public int updateById(PhotoInfo photoInfo);

    /**
     * @param id
     * @return
     */
    public int deleteById(Integer id);

}
