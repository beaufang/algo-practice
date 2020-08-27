package com.beau;

import org.junit.Test;

import java.util.TreeMap;

public class Solution {





    public int findLatestStep(int[] arr, int m) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int n = arr.length;
        map.put(1, n);
        if (m == n) return n;
        for (int i = n - 1; i >= 0; i--) {
            int idx = arr[i];
            int start = map.floorKey(idx);
            int end = map.get(start);
            if (idx > start) {
                if (idx - start == m) return i;
                map.put(start, idx-1);
            }
            if (idx < end) {
                if (end - idx == m) return i;
                map.put(idx+1, end);
            }
        }
        return -1;
    }

    public int findLatestStep2(int[] arr, int m) {
        int ans = -1;
        int len = arr.length;
        int target = ((1 << m) - 1);
        int mask = target << (len - m - 1);
        int num = 0;
        for (int i = 0; i < len; i++) {
            num |= (1 << (len - arr[i]));
            int temp = mask;
            while (temp >= target) {
                if ((num & temp) == target) {
                    ans = i;
                    break;
                }
                temp = temp >> m;
            }
        }
        return ans;
    }

    @Test
    public void test3() {
        System.out.println(findLatestStep(new int[]{3, 5, 1, 2, 4}, 1));
    }
}
