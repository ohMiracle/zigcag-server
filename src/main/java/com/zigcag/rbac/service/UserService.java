package com.zigcag.rbac.service;


import com.zigcag.rbac.model.User;

import java.util.List;
import java.util.Map;


public interface UserService {

	String addUser(User sysUser);

    List<User> listUser(Map<String, Object> params);

	boolean editUser(User sysUser);

	boolean deleteUser(String id);

	boolean checkAccountExist(String account);
}
