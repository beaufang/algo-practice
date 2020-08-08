package com.beau.leetcode.old;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/8
 * 322 https://leetcode-cn.com/problems/coin-change/description/
 */
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示兑换到数额为 i 的钱，最少需要的硬币的数量
        // dp[i] = 1 + min(dp[i - 1], dp[i - 2], dp[i - 5]);
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
