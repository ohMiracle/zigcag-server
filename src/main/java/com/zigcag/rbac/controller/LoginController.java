package com.zigcag.rbac.controller;

import com.zigcag.rbac.controller.bean.LoginParam;
import com.zigcag.rbac.model.Menu;
import com.zigcag.rbac.model.Msg;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.MenuService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/6
 */
@RestController
public class LoginController {
    Logger logger=LoggerFactory.getLogger(LoginController.class);
    @Resource
    MenuService menuService;
    @RequestMapping
    public Msg login(@RequestBody(required = false) @Valid LoginParam loginParam) {
        if (ObjectUtils.isEmpty(loginParam)) {
            return Msg.error();
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(loginParam.getAccount(), loginParam.getPassword());
            subject.login(usernamePasswordToken);
            User user = (User) subject.getPrincipal();
            String roleId = user.getRoleId();
            List<Menu> menuList = menuService.getMenuListByRoleId(roleId);
            user.setMenuList(menuList);
            //TODO 处理记住密码
            return Msg.success("登录成功").add("user",user);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return Msg.error("登录失败，用户名不存在或密码错误");
        }catch (Exception e){
            return Msg.error("未知错误"+e.getMessage());
        }
    }
    @RequestMapping("/logout")
    public Msg logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return Msg.success("成功退出");
    }

    @RequestMapping("unauthorized")
    public Msg unauthorized(){
        return Msg.error("未登录");
    }
}
