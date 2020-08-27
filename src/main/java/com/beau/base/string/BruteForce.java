package com.beau.base.string;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/25
 */
public class BruteForce {

    /**
     *
     * @param txt 主串
     * @param pat 模式串
     * @return 匹配位置索引
     */
    public int find(String txt, String pat) {
        int m = pat.length(), n = txt.length();
        // 枚举所有起点
        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            // 对比主串和模式串是否匹配
            for (int j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return i;
            }
        }
        return -1;
    }

    public int find2(String txt, String pat) {
        int m = pat.length(), n = txt.length();
        int i = 0, j = 0;
        while (i < n && j < m)  {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j == m) {
                return i - m;
            }
        }
        return -1;
    }


    @Test
    public void test() {
        System.out.println(find("aabbbacda", "da"));
        System.out.println(find("aabbbacda", "cd"));
        System.out.println(find("aabbbacda", "ce"));
        System.out.println(find("aabbbacda", "aa"));
    }

    @Test
    public void test2() {
        System.out.println(find2("aabbbacda", "da"));
        System.out.println(find2("aabbbacda", "cd"));
        System.out.println(find2("aabbbacda", "ce"));
        System.out.println(find2("aabbbacda", "aa"));
    }
}
