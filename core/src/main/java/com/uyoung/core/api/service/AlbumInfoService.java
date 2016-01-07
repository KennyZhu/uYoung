package com.uyoung.core.api.service;

import com.uyoung.core.api.model.AlbumInfo;
import com.uyoung.core.base.bean.Page;

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

    /**
     * @param id
     * @return
     */
    public AlbumInfo getById(Integer id);


    /**
     * 更新信息
     *
     * @param albumInfo
     * @return
     */
    public int updateById(AlbumInfo albumInfo);

    /**
     * 删除相册,删除相册中的所有照片信息
     *
     * @param id
     * @return
     */
    public int deleteById(Integer id);

    /**
     * 根据创建者获取
     * page和pageSize 有一个为null 不分页
     *
     * @param createUserId
     * @param page
     * @param pageSize
     * @return
     */
    public Page<AlbumInfo> getPageByCreateUserId(Integer createUserId, Integer page, Integer pageSize);

    /**
     * 增加点赞数
     *
     * @param id
     * @return
     */
    boolean incLikeCount(Integer id);

    /**
     * 取消点赞数
     *
     * @param id
     * @return
     */
    boolean decLikeCount(Integer id);


    /**
     * 更新封面照片URL
     *
     * @param id
     * @param firstPhotoUrl
     * @return
     */
    boolean updateFirstPhotoUrl(Integer id, String firstPhotoUrl);
}
