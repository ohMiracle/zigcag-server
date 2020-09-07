package com.zigcag.rbac.service;


import com.zigcag.rbac.model.User;

import java.util.List;
import java.util.Map;


public interface UserService {

	Long addUser(User sysUser);

    List<User> listUser(Map<String, Object> params);

	boolean editUser(User sysUser);

	boolean deleteUser(Long id);

	boolean checkAccountExist(String account);
}
