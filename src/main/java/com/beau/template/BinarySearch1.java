package com.beau.template;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/19
 */
public class BinarySearch1 {

    public int search(int[] nums, int target) {
        // 特殊用例判断
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        // 在 [left, right] 区间里查找 target
        int left = 0;
        int right = len - 1;
        while (left <= right) {
            // 为了防止 left + right 整形溢出，写成如下形式
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                // 下一轮搜索区间：[left, mid - 1]
                right = mid - 1;
            } else {
                // 此时：nums[mid] < target，下一轮搜索区间：[mid + 1, right]
                left = mid + 1;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] a = {1, 3, 5, 6, 7, 9};
        System.out.println(search(a, 5));
        System.out.println(search(a, 2));
    }
}
