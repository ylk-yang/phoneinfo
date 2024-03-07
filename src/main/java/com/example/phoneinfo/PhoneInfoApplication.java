package com.example.phoneinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.phoneinfo.dao")
public class PhoneInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhoneInfoApplication.class, args);
    }

}
