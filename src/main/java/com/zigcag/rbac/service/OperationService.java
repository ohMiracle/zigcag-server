package com.zigcag.rbac.service;

import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
public interface OperationService {
    Set<String> getOperationListByRoleId(String roleId);
}
