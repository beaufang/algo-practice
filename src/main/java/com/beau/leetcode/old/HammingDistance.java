package com.beau.leetcode.old;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/14
 * 461 https://leetcode-cn.com/problems/hamming-distance/
 */
public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int z = x ^ y;
        int ans = 0;
        while (z != 0) {
            z &= z - 1;
            ans++;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(hammingDistance(1, 4));
    }
}
