package com.timothy.lean1.service;

import com.timothy.common.bean.BlogInfo;

import java.util.List;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/12 12:14
 */
public interface BlogService {
    public List<BlogInfo> list(BlogInfo blogInfo) throws IllegalAccessException;

    public void test();
}
