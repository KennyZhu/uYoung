package com.uyoung.core.base.bean;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public class Page<T> {
    private int pageSize;
    private int totalPage;
    private List<T> dataList;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
