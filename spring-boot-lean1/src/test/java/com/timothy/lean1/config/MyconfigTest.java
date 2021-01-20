package com.timothy.lean1.config;

import com.timothy.common.bean.BlogInfo;
import com.timothy.common.bean.InitTestBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description:
 * @Author: timothyyu
 * @Date: 2021/1/26 14:35
 */
@SpringBootTest
@RunWith(value = SpringJUnit4ClassRunner.class)
class MyconfigTest {
    @Resource
    BlogInfo blogInfo;

    @Resource
    ApplicationContext applicationContext;

    @Test
    void blogInfo() {
//        System.out.println(bean);
        Map<String, BlogInfo> beansOfType = applicationContext.getBeansOfType(BlogInfo.class);
        beansOfType.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });
    }

    @Test
    void initTest2() {
        Object bean = applicationContext.getAutowireCapableBeanFactory().createBean(InitTestBean.class, AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE, false);
        System.out.println(bean);
    }
}