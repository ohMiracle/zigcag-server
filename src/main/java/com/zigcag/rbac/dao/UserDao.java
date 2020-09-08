package com.zigcag.rbac.dao;

import com.zigcag.rbac.model.User;
import com.zigcag.rbac.controller.bean.UserQueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    int insertUser(User user);

    List<User> listUser(UserQueryParam params);

    int editUser(User sysUser);

    int deleteUser(@Param("uid") Long uid);

    // int getCountByAccount(@Param("account") String account);

    Long getUidByDbid(@Param("dbid") int dbid);

    int deleteUid(@Param("uid") Long uid);

    User getPassword(@Param("account")String account);
}