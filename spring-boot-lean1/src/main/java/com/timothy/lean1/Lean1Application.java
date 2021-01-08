package com.timothy.lean1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/8 14:31
 */
@ComponentScan(value = "com.timothy.common.component")
@SpringBootApplication
public class Lean1Application {
    public static void main(String[] args) {
        SpringApplication.run(Lean1Application.class, args);
    }
}
