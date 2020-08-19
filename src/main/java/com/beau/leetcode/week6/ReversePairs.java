package com.beau.leetcode.week6;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/18
 * 493 https://leetcode-cn.com/problems/reverse-pairs/
 */
public class ReversePairs {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] arr, int left, int right) {
        if (right <= left) return 0;
        int mid = left + (right - left) / 2;
        int count = 0;
        // 翻转对的数量为左区间元素形成的翻转对数量+右区间元素翻转对数量+左区间元素和右区间元素形成的反转对数量
        count += mergeSort(arr, left, mid);
        count += mergeSort(arr, mid + 1, right);
        // 在 merge 之前统计左区间和右区间形成的翻转对的个数
        int i = left, j = mid + 1;
        while (i <= mid) {
            // 除 2.0 防止溢出
            while (j <= right && arr[i] / 2.0 > arr[j]) {
                j++;
            }
            // 重点理解，i 和 [mid+1,j) 直接的元素都可以形成翻转对
            count += j - (mid + 1);
            i++;
        }
        merge(arr, left, mid, right);
        return count;
    }

    // 合并
    private void merge(int[] arr, int left, int mid, int right) {
        // 中间数组
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }

    @Test
    public void test() {
//        int[] arr = {1, 3, 2, 3, 1};
        int[] arr = {2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        int res = reversePairs(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}
