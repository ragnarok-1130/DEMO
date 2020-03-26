package com.lee.demo.service.protocol;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.api.protocol.user.UserServiceProtocol;
import com.lee.demo.service.intf.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LCQ
 */
@Slf4j
@Service("userServiceProtocol")
public class UserServiceProtocolImpl implements UserServiceProtocol {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDto selectUser(Long userId) {
        return userService.selectUser(userId);
    }

    @Override
    public Result register(UserDto userDto) {
        return userService.register(userDto);
    }

    @Override
    public UserDto selectUserByUserName(String username) {
        return userService.selectUserByUserName(username);
    }

    @Override
    public List<UserDto> queryList(Map<String, Object> params) {
        return userService.queryList(params);
    }
}
