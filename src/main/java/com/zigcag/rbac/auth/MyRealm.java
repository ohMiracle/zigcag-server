package com.zigcag.rbac.auth;

import com.zigcag.rbac.model.Permission;
import com.zigcag.rbac.model.User;
import com.zigcag.rbac.service.OperationService;
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
    OperationService operationService;
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        super.setCredentialsMatcher(credentialsMatcher);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(user.getRoleName());
        Set<String> operationSet = operationService.getOperationListByRoleId(user.getRoleId());
        simpleAuthorizationInfo.setStringPermissions(operationSet);
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        User user = userService.getPassword(principal);
        if (user == null) {
            throw new UnknownAccountException();
        }
        String password = user.getPassword();
        String salt = user.getSalt();
        user.setPassword(null);
        user.setSalt(null);
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, password, ByteSource.Util.bytes(salt), getName());
        return authenticationInfo;
    }
}
