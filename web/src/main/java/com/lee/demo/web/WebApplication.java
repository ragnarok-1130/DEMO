package com.lee.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author LCQ
 */
@SpringBootApplication
@ImportResource(value = "classpath:dubbo/dubbo-consumer.xml")
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        log.info("--------ServiceApplication started successfully--------");
    }
}
