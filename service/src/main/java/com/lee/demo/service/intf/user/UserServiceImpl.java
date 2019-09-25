package com.lee.demo.service.intf.user;

import com.lee.demo.api.common.Result;
import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.service.entity.user.UserEntity;
import com.lee.demo.service.mapper.UserMapper;
import com.lee.demo.service.impl.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author LCQ
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDto selectUser(Long userId) {
        return userMapper.selectByUserId(userId);
    }

    @Override
    public Result register(UserDto userDto) {
        try {
            UserEntity userEntity = new UserEntity();
            BeanUtils.copyProperties(userDto, userEntity);
            if (userMapper.insertSelective(userEntity) > 0) {
                return new Result<>(true, null, "注册成功");
            } else {
                return new Result<>(false, null, "注册失败");
            }
        }catch (Exception e){
            return new Result<>(false, null, "注册操作出现异常");
        }
    }
}
