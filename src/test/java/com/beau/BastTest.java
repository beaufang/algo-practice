package com.beau;

import org.junit.Test;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/7
 */
public class BastTest {

    /**
     *  Collections.singletonList 生成的集合时不可变的，无法进行修改操作
     */
    @Test
    public void testUnsupportedOperationException() {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Collections.singletonList(1));
        map.get(1).add(2);
    }


    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int p = 0, q = 0, l = 1;
        for (int i = 1; i< n; i++) {
            p = q;
            q = l;
            l = p + q;
        }
        return l;
    }

    @Test
    public void testFib() {
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(48));
    }

    @Test
    public void test() {
        System.out.println(1_000);
    }

    @Test
    public void test2() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            System.out.println(random.nextInt(26));
        }
    }
}
