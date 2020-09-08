package com.zigcag.rbac.service;

import com.zigcag.rbac.model.Permission;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
public interface PermissionService {
    Set<String> getPermissionListByRoleId(String roleId);
}
