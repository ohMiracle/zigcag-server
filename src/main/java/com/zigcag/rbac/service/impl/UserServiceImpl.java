package com.zigcag.rbac.service.impl;

import com.zigcag.rbac.dao.UserDao;
import com.zigcag.rbac.exception.RbacException;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.model.UserQueryParam;
import com.zigcag.rbac.service.UserService;
import com.zigcag.rbac.utils.EncryptUtil;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;

	@Override
	@Transactional
	public Long addUser(User user) {
		EncryptUtil.encryptPassword(user);
		//1.查询sys_user表总数
		//2.随机 1-总数 中随机
		//3.根据随机数查取根据dbid查取uid
		//4.删除此条数据
		//步骤3和步骤4加锁？
		Long uid = getUid();
		user.setUid(uid);
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		userDao.insertUser(user);
		return uid;
	}

	private synchronized Long getUid() {
		int i = RandomUtils.nextInt(1, 1000);
		Long uid = userDao.getUidByDbid(i);
		int deleteUidResult = userDao.deleteUid(uid);
		if(deleteUidResult!=1){
			throw new RbacException("获取uid失败！");
		}
		return uid;
	}
	@Override
	public List<User> listUser(UserQueryParam params) {
		return userDao.listUser(params);
	}

	@Override
	public boolean editUser(User sysUser) {
		sysUser.setUpdateTime(new Date());
		return userDao.editUser(sysUser) == 1;
	}

	@Override
	public boolean deleteUser(Long id) {
		return userDao.deleteUser(id) == 1;
	}


}
