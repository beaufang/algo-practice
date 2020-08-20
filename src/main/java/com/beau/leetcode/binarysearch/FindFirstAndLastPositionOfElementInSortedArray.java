package com.beau.leetcode.binarysearch;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 34 https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) return new int[]{-1, -1};
        int left = searchLeft(nums, target);
        if (left == -1) return new int[]{-1, -1};
        int right = searchRight(nums, target);
        return new int[]{left, right};
    }

    /**
     * 查找右边界
     */
    private int searchRight(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    /**
     * 查找左边界
     */
    private int searchLeft(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
    }

    @Test
    public void test() {
        int[] a = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(a, 8)));
        System.out.println(Arrays.toString(searchRange(a, 5)));
    }
}
