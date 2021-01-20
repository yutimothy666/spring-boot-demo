package com.timothy.lean1;

import com.google.common.base.Strings;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.timothy.common.config.BlogStatus;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * @Author yutimothy
 * @Date 2020/12/28 18:24
 * @Version 1.0
 */
//@RunWith(value = SpringJUnit4ClassRunner.class)
//@SpringBootTest
public class test {
    public static InheritableThreadLocal<Integer> integerInheritableThreadLocal = new InheritableThreadLocal<>();

    @Test
    public void test1() throws InterruptedException {
        String a = "121212";
        System.out.println(a.replace('1', '2'));
        System.out.println(a.replace("12", "233"));
        System.out.println(BlogStatus.getMap());
        LongAdder longAdder = new LongAdder();
        IntStream.range(1, 100).forEach(a1 -> {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    longAdder.increment();
                }
            }).start();
            try {
                Thread.sleep(200);
                System.out.println(Thread.currentThread().getName() + "_" + longAdder.sum());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread.sleep(2000);
        System.out.println(longAdder.sum());
    }

    private static int num1 = 0;

    @Test
    public void test2() throws InterruptedException {
        integerInheritableThreadLocal.set(4);
        int a2 = 0;
        Run1 run1 = new Run1();
        for (int i = 0; i < 20; i++) {
            new Thread(run1).start();
//            new Thread(new Run1());
        }

        Thread.sleep(1000);
        System.out.println(num1);
    }

    public static class Run1 implements Runnable {
        private int a3 = 0;
        private final static Object lock = new Object();

        @Override
        public void run() {
            a3++;
            System.out.println(integerInheritableThreadLocal.get());
            Integer integer = integerInheritableThreadLocal.get() + 1;
            integerInheritableThreadLocal.set(integer);
            System.out.println(Thread.currentThread().getName() + "_" + a3);

        }
    }

    @Test
    public void test3() {
        System.out.println(Strings.repeat("q", 3));
        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("1", "3");
        biMap.put("2", "4");
        System.out.println(biMap.get("1"));
        System.out.println(biMap.inverse().get("3"));
    }

    class P1 {
        public void test() {
            test2();
        }

        public void test2() {
            System.out.println("ok");
        }
    }

    class C1 extends P1 {
        @Override
        public void test2() {
            System.out.println("c1");
        }

        @Override
        public void test() {
            System.out.println("ct");
            super.test();
        }
    }

    @Test
    public void test5() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        C1 c1 = new C1();
        c1.test();
        boolean active = false;
        try {
            Class.forName("com.timothy.lean1.Lean1Applicationa", true, this.getClass().getClassLoader());
            active = true;
        } catch (ClassNotFoundException e) {
            active = false;
//            e.printStackTrace();
        }
        System.out.println(active);
    }
}
