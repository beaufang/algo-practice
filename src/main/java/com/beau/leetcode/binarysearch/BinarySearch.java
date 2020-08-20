package com.beau.leetcode.binarysearch;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 704 https://leetcode-cn.com/problems/binary-search/
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return -1;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (target < nums[mid]) {
                right = mid - 1;
            }
            if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
