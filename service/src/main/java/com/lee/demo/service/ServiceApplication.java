package com.lee.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LCQ
 */
@SpringBootApplication
@Slf4j
public class ServiceApplication {

    public static void main(String[] args) {
        new SpringApplication(ServiceApplication.class).run(args);
        log.info("--------ServiceApplication started successfully--------");
    }
}
