package com.lee.demo.api.protocol.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;

import java.util.List;
import java.util.Map;

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

    /**
     * 查询用户列表
     * @param params
     * @return
     */
    List<UserDto> queryList(Map<String, Object> params);
}
