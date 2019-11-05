package com.lee.demo.api.protocol.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;

/**
 * @author LCQ
 */
public interface UserServiceProtocol {

    /**
     * 根据userId查询用户信息
     * @param userId
     * @return
     */
    UserDto selectUser(Long userId);

    /**
     * 新用户注册
     * @param userDto
     * @return
     */
    Result register(UserDto userDto);

    /**
     * 根据username查询用户
     * @param username
     * @return
     */
    UserDto selectUserByUserName(String username);
}
