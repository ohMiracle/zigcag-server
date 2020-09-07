package com.zigcag.rbac.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zigcag.rbac.model.Msg;
import com.zigcag.rbac.model.BasePageBean;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.model.UserQueryParam;
import com.zigcag.rbac.service.UserService;
import com.zigcag.rbac.utils.EncryptUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/listUser")
	public Msg listUser(@RequestBody UserQueryParam userQueryParam) {
		PageHelper.startPage(userQueryParam.getCurrent(), userQueryParam.getPageSize());
		Map<String, Object> params = new HashMap<>();
		List<User> UserList = userService.listUser(params);
		PageInfo page = new PageInfo(UserList);
		return Msg.success("成功查询用户列表").add("userList",UserList).add("total",page.getTotal());
	}
	@RequestMapping("/addUser")
	public Msg addUser(@RequestBody @Valid User user){

		// boolean isAccountExist = userService.checkAccountExist(user.getAccount());
		// if(isAccountExist){
		// 	return Msg.error("用户已存在");
		// }
		long uid = userService.addUser(user);
		return Msg.message(201,"成功新增用户").add("id",uid);
	}

	@RequestMapping("/editUser")
	public Msg editUser(@RequestBody @Valid User User){
		boolean b = userService.editUser(User);
		if (!b) {
			return Msg.error("用户ID不存在！");
		}
		return Msg.message(201,"成功编辑用户");
	}

	@RequestMapping("/deleteUser")
	public Msg deleteUser( @RequestBody Long id) throws Exception{
		if(id == null){
			return Msg.error("用户ID为空");
		}
		boolean b=userService.deleteUser(id);
		if(!b){
			return Msg.error("用户ID不存在");
		}
		return Msg.message(201,"成功删除用户");
	}

}
