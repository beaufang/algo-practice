package com.beau.leetcode.oferr;

/**
 * @author BeauFang
 * Date: 2020/8/12
 * 剑指 Offer 10- I. 斐波那契数列 https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 */
public class Fib_Off10_1 {

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        int p = 0, q = 0, l = 1;
        for (int i = 1; i < n; i++) {
            p = q;
            q = l;
            l = (p + q) % 1000000007;
        }
        return l;
    }
}
