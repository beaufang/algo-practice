package com.beau.leetcode.old;

/**
 * @author BeauFang
 * Date: 2020/8/8
 * 198 https://leetcode-cn.com/problems/house-robber/
 */
public class HouseRobber {


    public int rob(int[] nums) {
        int rob = 0;
        int unRob = 0;
        for (int num : nums) {
            int tmp = rob;
            rob = unRob + num;
            unRob = Math.max(unRob, tmp);
        }
        return Math.max(rob, unRob);
    }

    public int rob2(int[] nums) {
        // dp[i][0] 第 i 个房子，不偷的最大收益 dp[i][0] = max(dp[i-1][0], dp[i-1][1])
        // dp[i][1] 第 i 个方式偷的最大收益 dp[i][1] = dp[i-1][0] + nums[i - 1]
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i - 1];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }
}
