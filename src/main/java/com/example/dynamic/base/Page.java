package com.example.dynamic.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Page<T>{
    /**
     * 页编号 : 第几页
     */
    private int page = 1;
    /**
     * 页大小 : 每页的数量
     */
    private int limit = 10;
    /**
     * 数据总数
     */
    private Integer total = 1;

    /**
     * 过滤条件
     */
    @JsonIgnore
    private T filter;
    protected List<T> data = new ArrayList<T>();
    public Page() {
        super();
    }

    public Page(int page) {
        this.page = page;
    }

    public Page(int page, int limit) {
        this.page = page;
        this.limit = limit;

    }

    public Page(T filter, int page, int limit) {
    	this.filter=filter;
        this.page = page;
        this.limit = limit;

    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getFilter() {
        return filter;
    }

    public void setFilter(T filter) {
        this.filter = filter;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
