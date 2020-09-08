package com.zigcag.rbac.auth;

import com.zigcag.rbac.model.Permission;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.PermissionService;
import com.zigcag.rbac.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Description:
 * @Author: zhengchang
 * @Date: 2020/9/7
 */
public class MyRealm extends AuthorizingRealm {

    @Resource
    UserService userService;
    @Resource
    PermissionService permissionService;
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        super.setCredentialsMatcher(credentialsMatcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //TODO principal可以是手机号或者邮箱
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRoleName());
        //TODO 通过角色信息查询权限信息
        Set<String> permissionList = permissionService.getPermissionListByRoleId(user.getRoleId());
        simpleAuthorizationInfo.setStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        //TODO 通过手机号或者邮箱查询该用户密码
        User user = userService.getPassword(principal);
        if (user == null) {
            throw new UnknownAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), ByteSource.Util.bytes(user.getSalt()), getName());
        return authenticationInfo;
    }
}
