package com.timothy.lean1.controller;

import com.timothy.common.bean.BlogInfo;
import com.timothy.common.config.AjaxResults;
import com.timothy.lean1.service.BlogService;
import com.timothy.lean1.service.TestService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @Author yutimothy
 * @Date 2020/12/28 18:28
 * @Version 1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/blog")
public class BlogController {
    @Resource
    BlogService blogService;
    @Resource
    TestService testService;


    @RequestMapping(value = {"", "/"})
    public AjaxResults<List<BlogInfo>> listTest(BlogInfo blogInfo) throws IllegalAccessException {
        testService.test();
        return AjaxResults.success(blogService.list(blogInfo));
    }
}
