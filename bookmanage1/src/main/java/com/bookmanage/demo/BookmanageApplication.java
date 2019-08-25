package com.bookmanage.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.bookmanage.demo")

public class BookmanageApplication {

    public static void main(String[] args) {

        SpringApplication.run(BookmanageApplication.class, args);
    }

}
