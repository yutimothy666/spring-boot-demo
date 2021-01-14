package com.timothy.lean1.service.Impl;

import com.timothy.lean1.service.BlogService;
import com.timothy.lean1.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/12 12:17
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    BlogService blogService;

    @Override
    public String test() {
        blogService.test();
        return "service";
    }

}
