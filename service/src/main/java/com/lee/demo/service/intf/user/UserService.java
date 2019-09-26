package com.lee.demo.service.intf.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;

/**
 * @author LCQ
 */
public interface UserService {
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
}
