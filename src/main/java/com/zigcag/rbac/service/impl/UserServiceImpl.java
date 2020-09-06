package com.zigcag.rbac.service.impl;

import com.zigcag.rbac.dao.UserDao;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	public String addUser(User user) {
		String uuid = UUID.randomUUID().toString();
		user.setId(uuid);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userDao.insertUser(user);
		return uuid;
	}

	@Override
	public List<User> listUser(Map<String,Object> params) {
		return userDao.listUser(params);
	}

	@Override
	public boolean editUser(User sysUser) {
		sysUser.setUpdateTime(new Date());
		return userDao.editUser(sysUser) == 1;
	}

	@Override
	public boolean deleteUser(String id) {
		return userDao.deleteUser(id) == 1;
	}

	@Override
	public boolean checkAccountExist(String account) {
		return userDao.getCountByAccount(account)> 0;
	}


}
