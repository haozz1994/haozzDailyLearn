package com.haozz.dailylearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haozz.dailylearn.mp.mapper")
public class DailylearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailylearnApplication.class, args);
    }

}
