package com.zigcag.rbac.model;

/**
 * @Description:
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
