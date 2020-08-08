package com.beau.leetcode.old;

/**
 * @author BeauFang
 * Date: 2020/8/8
 * 53 https://leetcode-cn.com/problems/maximum-subarray/
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int pre = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pre = Math.max(pre, 0) + nums[i];
            max = Math.max(max, pre);
        }
        return max;
    }
}
