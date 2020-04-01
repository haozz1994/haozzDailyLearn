package com.haozz.dailylearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication
@MapperScan("com.haozz.dailylearn.mp.mapper")
@EnableRetry
public class DailylearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailylearnApplication.class, args);
    }

}
