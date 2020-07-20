package com.beau.leetcode.old;

// 5 最长回文字符串
public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        // dp[i][j] 表示 字符区间 i,j 之间是否是回文字符串
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (len == 1 || s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] || len == 2)) {
                    dp[i][j] = true;
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        String res = s.longestPalindrome("accbc");
        System.out.println(res);
    }
}
