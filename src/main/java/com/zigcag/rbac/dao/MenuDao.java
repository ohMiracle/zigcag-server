package com.zigcag.rbac.dao;

import com.zigcag.rbac.model.Menu;

import java.util.List;

public interface MenuDao {


    List<Menu> getMenuListByRoleId(String roleId);
}