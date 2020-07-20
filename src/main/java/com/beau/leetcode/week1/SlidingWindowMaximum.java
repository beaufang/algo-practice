package com.beau.leetcode.week1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 239 https://leetcode-cn.com/problems/sliding-window-maximum/
 */
public class SlidingWindowMaximum {

    // 单调队列
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 1) {
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 移除所有过期的数据
            while (!deque.isEmpty() && (i - deque.peekFirst() >= k)) {
                deque.pollFirst();
            }
            // 保持队列的递减
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
            if (!deque.isEmpty() && i >= k - 1) {
                ans[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum windowMaximum = new SlidingWindowMaximum();
//        int[] nums = {1,3,-1,-3,5,3,6,7};
        // [3, 3, 2, 5]
        int[] nums = {1, 3, 1, 2, 0, 5};
        System.out.println(Arrays.toString(windowMaximum.maxSlidingWindow(nums, 3)));

    }
}
