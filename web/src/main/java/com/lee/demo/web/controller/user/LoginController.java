package com.lee.demo.web.controller.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.protocol.user.UserServiceProtocol;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LCQ
 */
@RestController
@Slf4j
public class LoginController {

    @Reference
    private UserServiceProtocol userServiceProtocol;

    @RequestMapping("/login")
    public Result login(String username, String password) {
        try {
            Subject subject = SecurityUtils.getSubject();
            AuthenticationToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            return Result.createSuccessResult("登录成功");
        } catch (AuthenticationException e) {
            log.error("登录失败： {} --- username:{}", e.getMessage(), username);
            return Result.createFailResult(e.getMessage());
        }
    }
}
