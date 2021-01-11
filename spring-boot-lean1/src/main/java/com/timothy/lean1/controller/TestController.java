package com.timothy.lean1.controller;

import com.timothy.common.config.AjaxResults;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author yutimothy
 * @Date 2020/12/25 12:31
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping(value = {"", "/"})
    public AjaxResults<String> test() {
        return AjaxResults.success("test");
    }
}
