package com.beau.leetcode.string;

/**
 * @author BeauFang
 * Date: 2020/8/24
 */
public class _459_RepeatedSubstringPattern {

    /**
     * 暴力枚举
     */
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            boolean match = true;
            for (int j = i; j < n; j++) {
                if (s.charAt(j) != s.charAt(j - i)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }

    // 双倍字符串
    public boolean repeatedSubstringPattern2(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
