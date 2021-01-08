package com.timothy;

import com.timothy.common.config.AjaxResults;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author yutimothy
 * @Date 2020/12/25 12:16
 * @Version 1.0
 */
@SpringBootApplication
public class SpringBootLean1 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLean1.class, args);
        System.out.println("--ok---");
    }

    @Controller
    @RequestMapping("/ping")
    public static class PingTestController {
        @RequestMapping(value = {"", "/"})
        @ResponseBody
        public AjaxResults<String> ping(@RequestParam(value = "ping", required = false, defaultValue = "") String ping) {
            return AjaxResults.success(ping);
        }
    }
}
