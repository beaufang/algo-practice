package com.beau.base.string;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/25
 */
public class KMP {

    public int find(String txt, String pat) {
        int n = txt.length(), m = pat.length();
        int[] next = getNexts(pat);
        int i = 0, j = 0;
        while (i < n && j < m) {
            // next[0] = -1 ，使得 j = -1 ,相当于把模式串移动到开头
            if (j == -1 || txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }

    /**
     * 生成 next 数组
     */
    private int[] getNexts(String pat) {
        int m = pat.length();
        int[] next = new int[m];
        next[0] = -1;
        // k表示公共前后缀的长度
        // 取 k = -1, 方便再循环中做处理，如求 next[1]的情况
        int j = 0, k = -1;
        while (j < m - 1) {
            if (k == -1 || pat.charAt(j) == pat.charAt(k)) {
                next[j + 1] = k + 1;
                k++;
                j++;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    @Test
    public void test() {
        System.out.println(Arrays.toString(getNexts("ababcababae")));
        System.out.println(find("aabbbacda", "da"));
        System.out.println(find("aabbbacda", "cd"));
        System.out.println(find("aabbbacda", "ce"));
        System.out.println(find("aabbbacda", "aa"));
    }
}
