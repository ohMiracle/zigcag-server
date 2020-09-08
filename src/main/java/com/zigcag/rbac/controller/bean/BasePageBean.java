package com.zigcag.rbac.controller.bean;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
public class BasePageBean {
    private int pageSize;
    private int current;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }
}
