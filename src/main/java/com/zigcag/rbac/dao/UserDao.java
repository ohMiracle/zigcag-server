package com.zigcag.rbac.dao;

import com.zigcag.rbac.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {

    int insertUser(User user);

    List<User> listUser(Map<String, Object> params);

    int editUser(User sysUser);

    int deleteUser(@Param("id") String id);

    int getCountByAccount(@Param("account") String account);
}