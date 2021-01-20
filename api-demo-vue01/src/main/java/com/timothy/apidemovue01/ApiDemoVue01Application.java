package com.timothy.apidemovue01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/28 12:16
 */
@SpringBootApplication(scanBasePackages ={"com.timothy.common.component","com.timothy.apidemovue01"})
public class ApiDemoVue01Application {
    public static void main(String[] args) {
        SpringApplication.run(ApiDemoVue01Application.class, args);
    }
}
