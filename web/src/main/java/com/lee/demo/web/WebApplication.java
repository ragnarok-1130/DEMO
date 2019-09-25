package com.lee.demo.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author LCQ
 */
@SpringBootApplication
@Slf4j
public class WebApplication {

    public static void main(String[] args) {
        new SpringApplication(WebApplication.class).run(args);
        log.info("--------ServiceApplication started successfully--------");
   }
}
