package com.lee.demo.web.config;

import com.lee.demo.api.dto.user.RoleDto;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.api.protocol.user.RoleServiceProtocol;
import com.lee.demo.api.protocol.user.UserServiceProtocol;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author LCQ
 */
@Component
@Slf4j
public class MyRealm extends AuthorizingRealm {

    @Reference
    private UserServiceProtocol userServiceProtocol;

    @Reference
    private RoleServiceProtocol roleServiceProtocol;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserDto user = (UserDto) principalCollection.getPrimaryPrincipal();
        List<String> permissions = roleServiceProtocol.queryPermissionByUserId(user.getId());
        Set<String> permissionSet = new HashSet<>(permissions);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setStringPermissions(permissionSet);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        UserDto user = userServiceProtocol.selectUserByUserName(token.getUsername());
        if (user == null) {
            log.info("用户:{} 不存在", token.getUsername());
            throw new AuthenticationException("用户名或密码不正确！");
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        return authenticationInfo;
    }
}
