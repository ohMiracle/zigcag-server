package com.zigcag.rbac.service;


import com.zigcag.rbac.model.User;
import com.zigcag.rbac.model.UserQueryParam;

import java.util.List;
import java.util.Map;


public interface UserService {

	Long addUser(User sysUser);

    List<User> listUser(UserQueryParam params);

	boolean editUser(User sysUser);

	boolean deleteUser(Long id);

}
