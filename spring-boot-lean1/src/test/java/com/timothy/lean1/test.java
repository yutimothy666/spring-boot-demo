package com.timothy.lean1;

import com.timothy.common.config.BlogStatus;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author yutimothy
 * @Date 2020/12/28 18:24
 * @Version 1.0
 */
@SpringBootTest
public class test {
    @Test
    public void test1() {
        System.out.println(BlogStatus.getMap());
    }
}
