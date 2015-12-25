package com.uyoung.core.api.service;

import com.uyoung.core.api.model.PhotoInfo;

import java.util.List;

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

    /**
     * 根据相册ID获取所有的照片
     *
     * @param albumId
     * @return
     */
    public List<PhotoInfo> getListByAlbumId(Integer albumId);


    public int deleteByAlbumId(Integer albumId);

    /**
     * Like 数增加
     *
     * @param photoId
     * @return
     */
    public int incLikeCount(Integer photoId);

    /**
     * Like 数减少
     *
     * @param photoId
     * @return
     */
    public int decLikeCount(Integer photoId);

    /**
     * 浏览数增加
     *
     * @param photoId
     * @return
     */
    public int incViewCount(Integer photoId);

}
