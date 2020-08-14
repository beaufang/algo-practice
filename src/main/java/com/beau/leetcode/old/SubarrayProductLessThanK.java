package com.beau.leetcode.old;

/**
 * @author BeauFang
 * Date: 2020/8/14
 * 713 https://leetcode-cn.com/problems/subarray-product-less-than-k/
 */
public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int ans = 0, window = 1, left = 0, right = 0;
        while (right < nums.length) {
            window = window * nums[right];
            while (window >= k) {
                window = window / nums[left];
                left++;
            }
            // 增量为以当前以nums[right]结尾的所有子串的数量
            ans += right - left + 1;
            right++;
        }
        return ans;
    }
}
