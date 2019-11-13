package com.lee.demo.web.controller.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.api.protocol.user.UserServiceProtocol;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LCQ
 */
@RequestMapping("/user")
@RestController
@Slf4j
public class UserController {

    @Reference
    private UserServiceProtocol userServiceProtocol;

    @RequestMapping("/register")
    public Result register(@RequestBody UserDto userDto) {
        if (userDto == null) {
            return Result.createFailResult("参数为空");
        }
        if (userDto.getUsername() == null || userDto.getUsername().isEmpty()) {
            return Result.createFailResult("用户名不能为空");
        }
        if (userDto.getPassword() == null || userDto.getPassword().isEmpty()) {
            return Result.createFailResult("密码不能为空");
        }
        int pwdLen = userDto.getPassword().length();
        if (pwdLen < 6 || pwdLen > 18) {
            return Result.createFailResult("密码长度须为6-18位");
        }
        String salt = RandomStringUtils.randomAlphanumeric(20);
        String encryptedPwd = new Md5Hash(userDto.getPassword(),userDto.getUsername()+salt,2).toBase64();
        userDto.setSalt(salt);
        userDto.setPassword(encryptedPwd);
        return userServiceProtocol.register(userDto);
    }
}
