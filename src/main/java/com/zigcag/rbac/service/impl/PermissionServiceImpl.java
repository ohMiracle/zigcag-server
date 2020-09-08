package com.zigcag.rbac.service.impl;

import com.zigcag.rbac.dao.PermissionDao;
import com.zigcag.rbac.model.Permission;
import com.zigcag.rbac.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
    PermissionDao permissionDao;
    @Override
    public Set<String> getPermissionListByRoleId(String roleId) {
        return permissionDao.getPermissionListByRoleId(roleId);
    }
}
