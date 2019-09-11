package com.lee.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author Administrator
 */
@SpringBootApplication
@Slf4j
public class ServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceApplication.class).web(WebApplicationType.NONE).run(args);
        log.info("--------ServiceApplication started successfully--------");
    }
}
