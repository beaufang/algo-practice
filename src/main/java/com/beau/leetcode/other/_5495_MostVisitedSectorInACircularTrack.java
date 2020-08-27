package com.beau.leetcode.other;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/23
 */
public class _5495_MostVisitedSectorInACircularTrack {

    public List<Integer> mostVisited(int n, int[] rounds) {
        int[] arr = new int[n + 1];
        int max = 0;
        int len = rounds.length;
        arr[rounds[0]]++;
        for (int i = 0; i < len - 1; i++) {
            int j = rounds[i] % n + 1;
            while (j != rounds[i + 1] % n + 1) {
                arr[j]++;
                max = Math.max(max, arr[j]);
                j = j % n + 1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == max) {
                ans.add(i);
            }
        }
        return ans;
    }

    @Test
    public void test() {
        System.out.println(mostVisited(4, new int[]{1, 3, 1, 2}));
        System.out.println(mostVisited(2, new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2}));
    }
}
