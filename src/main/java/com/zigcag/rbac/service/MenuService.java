package com.zigcag.rbac.service;

import com.zigcag.rbac.model.Menu;

import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/8
 */
public interface MenuService {
    List<Menu> getMenuListByRoleId(String roleId);
}
