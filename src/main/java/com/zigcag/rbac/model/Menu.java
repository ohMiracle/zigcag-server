package com.zigcag.rbac.model;

import java.util.Date;

public class Menu {
    /**
     *
     */
    private Integer dbid;

    /**
     *
     */
    private String id;

    /**
     *
     */
    private String parentId;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private Date updateTime;

    public Integer getDbid() {
        return dbid;
    }

    public void setDbid(Integer dbid) {
        this.dbid = dbid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}

