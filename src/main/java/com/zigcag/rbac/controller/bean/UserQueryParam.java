package com.zigcag.rbac.controller.bean;

/**
 * @Description: 用户查询参数，角色展示时会使用
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
public class UserQueryParam extends BasePageBean {
    private String roleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
