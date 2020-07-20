package com.beau.leetcode.old;

// 28 实现 strStr()
public class StrStr {

    // KMP 算法
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        int m = haystack.length(), n = needle.length();
        if (n == 0) {
            return 0;
        }
        int[] lps = genLPS(needle);
        int i = 0, j = 0;
        while (i < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
                if (j == n) {
                    return i-n;
                }
            } else {
                if (j > 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return -1;
    }

    // 生成 LPS 数组
    private int[] genLPS(String pattern) {
        int n = pattern.length();
        int[] lps = new int[n];
        int i = 1, len = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0){
                len = lps[len -1];
            } else {
                i++;
            }
        }

        return lps;
    }

    // 暴力算法
    public int strStr01(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                // 匹配成功条件：j = len(needle)
                if (j == needle.length()) return i;
                // 超出母串范围
                if (i + j >= haystack.length()) return -1;
                // 进行下次匹配
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    public static void main(String[] args) {
//        test01();
        test02();
    }

    public static void test01() {
        StrStr s = new StrStr();
        System.out.println(s.strStr01("aaa", "aaaa"));
    }

    public static void test02() {
        StrStr s = new StrStr();
        System.out.println(s.strStr01("hello", "ll"));
    }
}
