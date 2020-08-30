package com.beau.leetcode.other;

import org.junit.Test;

import java.util.Random;

/**
 * @author BeauFang
 * Date: 2020/8/30
 */
public class _215_KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        // 目标元素的索引
        int target = len - k;
        int l = 0, r = len - 1;
        while (true) {
            int idx = partition(nums, l, r);
            if (target == idx) return nums[idx];
            if (target < idx) {
                r = idx - 1;
            } else {
                l = idx + 1;
            }
        }
    }

    private int partition(int[] nums, int l, int r) {
        Random random = new Random();
        // 生成一个随机数 l ~ r 之间的随机数最为 pivot
        int idx = random.nextInt(r - l + 1) + l;
        // 将 pivot 放在最后
        swap(nums, idx, r);
        int x = l, z = nums[r];
        for (int y = l; y < r; y++) {
            if (nums[y] < z) {
                swap(nums, x, y);
                x++;
            }
        }
        swap(nums, x, r);
        return x;
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    @Test
    public void test() {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(arr, 2));
        System.out.println(findKthLargest(arr, 3));
    }
}
