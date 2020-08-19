package com.beau;

import org.junit.Test;

import java.util.Arrays;

public class Solution {

    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }
    private int mergeSort(int[] nums, int s, int e){
        if(s>=e) return 0;
        int mid = s + (e-s)/2;
        int cnt = mergeSort(nums, s, mid) + mergeSort(nums, mid+1, e);
        for(int i = s, j = mid+1; i<=mid; i++){
            while(j<=e && nums[i]/2.0 > nums[j]) j++;
            cnt += j-(mid+1);
        }
        Arrays.sort(nums, s, e+1);
        return cnt;
    }

    @Test
    public void test() {
        int[] arr = {2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647};
        int res = reversePairs(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(res);
    }
}
