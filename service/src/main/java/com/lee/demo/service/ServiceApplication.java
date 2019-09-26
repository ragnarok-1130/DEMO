package com.lee.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LCQ
 */
@SpringBootApplication
@ImportResource(value = "classpath:dubbo/dubbo-provider.xml")
@Slf4j
public class ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
        log.info("--------ServiceApplication started successfully--------");
    }
}
