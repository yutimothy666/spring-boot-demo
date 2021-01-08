package com.timothy.lean1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author yutimothy
 * @Date 2020/12/25 12:16
 * @Version 1.0
 */
@ComponentScan(value = "com.timothy.common.component")
@SpringBootApplication
public class SpringBootLean1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLean1.class, args);
    }
}
