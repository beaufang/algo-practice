package com.beau.template;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/19
 */
public class BinarySearch2 {

    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left] == target ? left : -1;
//        return left;
    }

    @Test
    public void test() {
        int[] a = {1, 3, 5, 6, 7, 9};
        TestCase.assertEquals(2,search(a, 5));
        TestCase.assertEquals(1, search(a, 2));
        TestCase.assertEquals(0, search(a, 1));
        TestCase.assertEquals(5, search(a, 9));
    }

    @Test
    public void test2() {
        int[] a = {5, 7, 7, 8, 8, 10};
        System.out.println(search(a, 8));
    }
}
