package com.beau.leetcode.old;

// 516 最长回文子序列
public class LongestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int n = s.length();

        // dp[i][j] 表示区间 i 到 j 之间最长回文长度
        int[][] dp = new int[n][n];

        // 对角线，只有一个字符，最长回文长度为 1
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        // 从长度为 2 的字符开始
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + (len == 2 ? 0 : dp[i + 1][j - 1]);
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        LongestPalindromeSubseq solution = new LongestPalindromeSubseq();
        System.out.println(solution.longestPalindromeSubseq("bbbab"));
    }
}
