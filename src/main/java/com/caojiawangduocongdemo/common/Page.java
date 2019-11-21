package com.caojiawangduocongdemo.common;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Page model.
 *
 * @author DC
 */
public class Page<T> implements Serializable {
    public static final int DEFAULT_PAGE_SIZE = 20;
    public static Page EMPTY;

    static {
        EMPTY = new Page();
        EMPTY.setTotal(0);
        EMPTY.setCurrent(1);
        EMPTY.setPageSize(DEFAULT_PAGE_SIZE);
    }

    @Expose
    private long total;

    @Expose
    private List<T> data;

    @Expose
    private int current;

    @Expose
    private int pageSize;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
