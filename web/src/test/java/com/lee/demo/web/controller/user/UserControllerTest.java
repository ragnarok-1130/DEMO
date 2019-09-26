package com.lee.demo.web.controller.user;

import com.lee.demo.api.protocol.user.UserServiceProtocol;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class UserControllerTest {

    @Reference
    private UserServiceProtocol userServiceProtocol;

    @Test
    void register() {
        log.info(userServiceProtocol.register(null).toString());
    }
}