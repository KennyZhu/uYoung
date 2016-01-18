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
     * @param idList
     * @return
     */
    List<String> getPhotoUrlListByIdList(List<Integer> idList);

    /**
     * 获取相册下照片总数
     *
     * @param albumId
     * @return
     */
    int getTotalCountByAlbumId(Integer albumId);

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
     * 批量删除
     *
     * @param idList
     * @return
     */
    public int deleteByIdList(List<Integer> idList);

    /**
     * 根据相册ID获取所有的照片
     *
     * @param albumId
     * @return
     */
    public List<PhotoInfo> getListByAlbumId(Integer albumId);


    /**
     * @param albumId
     * @return
     */
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
    public boolean decLikeCount(Integer photoId);

    /**
     * 浏览数增加
     *
     * @param photoId
     * @return
     */
    public boolean incViewCount(Integer photoId);

}
