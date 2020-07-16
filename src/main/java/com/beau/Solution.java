package com.beau;

import com.beau.common.ListNode;

public class Solution {

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        if (k == 0) {
            return;
        }
        for (int start = 0; start < len; start++) {
            int current = start;
            int pre = nums[current];
            do {
                int next = (start + k) % len;
                int tmp = nums[next];
                nums[next] = pre;
                current = next;
                pre = tmp;
            } while (current != start);
        }
    }
}
