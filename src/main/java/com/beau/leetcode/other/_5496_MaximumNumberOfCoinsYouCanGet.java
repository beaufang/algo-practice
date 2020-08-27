package com.beau.leetcode.other;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/23
 */
public class _5496_MaximumNumberOfCoinsYouCanGet {

    public int maxCoins(int[] piles) {
        int ans = 0;
        Arrays.sort(piles);
        int i = 0, j = piles.length - 1;
        while (i < j) {
            j--;
            i++;
            ans += piles[j];
            j--;
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4}));
        System.out.println(maxCoins(new int[]{2, 4, 5}));
    }
}
