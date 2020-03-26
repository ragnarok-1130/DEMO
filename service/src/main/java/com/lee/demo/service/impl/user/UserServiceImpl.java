package com.lee.demo.service.impl.user;

import com.alibaba.fastjson.JSONObject;
import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.service.entity.user.UserEntity;
import com.lee.demo.service.intf.user.UserService;
import com.lee.demo.service.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author LCQ
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public UserDto selectUser(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public Result register(UserDto userDto) {
        try {
            if (userDto == null) {
                return Result.createFailResult(null, "参数为空");
            }
            UserDto user = userMapper.selectUserByUserName(userDto.getUsername());
            if (user != null) {
                return Result.createFailResult(null, "用户名已存在");
            }
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            if (userMapper.insertSelective(userEntity) > 0) {
                return Result.createSuccessResult("注册成功");
            } else {
                return Result.createFailResult(null, "注册失败");
            }
        } catch (Exception e) {
            return Result.createFailResult(null, "注册操作出现异常");
        }
    }

    @Override
    public UserDto selectUserByUserName(String username) {
        return userMapper.selectUserByUserName(username);
    }

    @Override
    public List<UserDto> queryList(Map<String, Object> params) {
        List<UserDto> userDtos = userMapper.queryList(params);
        return userDtos;
    }
}
