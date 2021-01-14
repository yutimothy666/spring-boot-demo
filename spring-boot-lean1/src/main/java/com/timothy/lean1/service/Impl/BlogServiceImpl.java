package com.timothy.lean1.service.Impl;

import com.timothy.common.bean.BlogInfo;
import com.timothy.common.config.BlogStatus;
import com.timothy.lean1.service.BlogService;
import com.timothy.lean1.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/12 12:18
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Resource
    TestService testService;

    @Override
    public List<BlogInfo> list(BlogInfo blogInfo) throws IllegalAccessException {
        ArrayList<BlogInfo> blogInfos = new ArrayList<>();
        if (Objects.nonNull(blogInfo)) {
            blogInfos.add(blogInfo);
        } else {
            IntStream.range(0, 20).forEach(item -> {
                blogInfos.add(BlogInfo.builder().blogTitle("" + item).blogContent("content" + item).userID((long) item).status(BlogStatus.AWAIT).numberOfVisits(0L).build());
            });
        }
        testService.test();
        return blogInfos;
    }

    @Override
    public void test() {
        System.out.println("test");
    }
}
