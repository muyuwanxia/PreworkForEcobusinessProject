package com.timi.test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.timi.test.mapper")
public class MPDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MPDemoApplication.class);
    }
}
