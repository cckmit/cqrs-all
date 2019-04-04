package com.honc.cqrs.cqrsall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.honc.*", "com.alibaba.sofa.*"})
@MapperScan(value = "com.honc.cqrs.cqrsall.mapper")
public class CqrsAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsAllApplication.class, args);
    }

}
