package com.uyoung.core.base.bean;

import java.util.List;

/**
 * User: KennyZhu
 * Date: 15/9/23
 * Desc:
 */
public class Page<T> {
    private int pageNum;
    private int pageSize;
    private int totalPage;
    private int totalSize;
    private List<T> dataList;

    public Page() {
        this.pageNum = 0;
        this.pageSize = 0;
        this.totalPage = 0;
        this.totalSize = 0;
    }

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

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    @Override
    public String toString() {
        return "Page{" +
                "dataList=" + dataList +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalSize=" + totalSize +
                '}';
    }
}
