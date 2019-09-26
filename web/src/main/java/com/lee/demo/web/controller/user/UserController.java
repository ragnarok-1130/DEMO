package com.lee.demo.web.controller.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.api.protocol.user.UserServiceProtocol;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
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
        return userServiceProtocol.register(userDto);
    }
}
