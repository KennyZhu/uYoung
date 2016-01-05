package com.uyoung.core.api.bean;

import com.uyoung.core.api.anno.Sort;
import com.uyoung.core.base.bean.SortCondition;

/**
 * User: KennyZhu
 * Date: 15/12/9
 * Desc:
 */
public class ActivityConditionBean extends SortCondition {
    /**
     * 活动类型
     */
    private Integer activityType;
    /**
     * 收费类型
     */
    private Integer feeType;
    /**
     * 活动状态
     */
    private Integer status;
    /**
     * 创建者
     */
    private Integer creatorUid;

    /**
     * 排序字段
     */
    @Sort(column = "create_time")
    private int createTimeSort;

    @Sort(column = "begin_time")
    private int beginTimeSort;


    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public Integer getFeeType() {
        return feeType;
    }

    public void setFeeType(Integer feeType) {
        this.feeType = feeType;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreatorUid() {
        return creatorUid;
    }

    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    public int getCreateTimeSort() {
        return createTimeSort;
    }

    public void setCreateTimeSort(int createTimeSort) {
        this.createTimeSort = createTimeSort;
    }

    public int getBeginTimeSort() {
        return beginTimeSort;
    }

    public void setBeginTimeSort(int beginTimeSort) {
        this.beginTimeSort = beginTimeSort;
    }

    @Override
    public String toString() {
        return "ActivityConditionBean{" +
                "activityType=" + activityType +
                ", feeType=" + feeType +
                ", status=" + status +
                ", creatorUid=" + creatorUid +
                ", createTimeSort=" + createTimeSort +
                ", sort=" + sort +
                ", sortColumn=" + sortColumn +
                ", beginTimeSort=" + beginTimeSort +
                '}';
    }
}
