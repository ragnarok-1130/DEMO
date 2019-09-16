package com.lee.demo.service.intf.user;

import com.lee.demo.api.dto.user.UserDto;
import com.lee.demo.service.impl.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void selectUser() {
        UserDto userDto = userService.selectUser(1L);
    }

    @Test
    void register() {
        UserDto userDto = new UserDto();
        userDto.setUsername("test");
        userDto.setPassword("test");
        userDto.setDisplayName("测试用户");
        log.info(userService.register(userDto).toString());
    }
}