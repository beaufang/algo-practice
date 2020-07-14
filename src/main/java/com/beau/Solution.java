package com.beau;

public class Solution {

    public int removeDuplicates(int[] nums) {
        // 双指针法
        if (nums.length < 2) {
            return nums.length;
        }
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i] && i - index >= 1) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
