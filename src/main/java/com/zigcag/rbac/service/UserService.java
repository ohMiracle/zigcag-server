package com.zigcag.rbac.service;


import com.zigcag.rbac.model.User;
import com.zigcag.rbac.controller.bean.UserQueryParam;

import java.util.List;


public interface UserService {

	Long addUser(User sysUser);

    List<User> listUser(UserQueryParam params);

	boolean editUser(User user);

	boolean deleteUser(Long id);

	User getPassword(String account);
}
