package com.zigcag.rbac.dao;

import com.zigcag.rbac.model.Permission;
import com.zigcag.rbac.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface PermissionDao {

    Set<String> getPermissionListByRoleId(String roleId);
}