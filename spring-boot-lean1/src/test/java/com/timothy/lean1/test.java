package com.timothy.lean1;

import com.timothy.common.config.BlogStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * @Author yutimothy
 * @Date 2020/12/28 18:24
 * @Version 1.0
 */
//@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest
public class test {
    @Test
    public void test1() {
        String a = "121212";
        System.out.println(a.replace('1', '2'));
        System.out.println(a.replace("12", "233"));
        System.out.println(BlogStatus.getMap());
    }
}
