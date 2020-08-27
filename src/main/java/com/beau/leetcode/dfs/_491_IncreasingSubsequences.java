package com.beau.leetcode.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/27
 */
public class _491_IncreasingSubsequences {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int level, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (level == nums.length) {
            if (path.size() >= 2) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        int last = path.size() > 0 ? path.getLast() : Integer.MIN_VALUE;
        // 选择当前元素
        if (nums[level] >= last) {
            path.add(nums[level]);
            dfs(nums, level + 1, path, ans);
            path.removeLast();
        }
        // 不选择当前元素
        if (nums[level] != last) {
            dfs(nums, level + 1, path, ans);
        }
    }

    @Test
    public void test() {
        System.out.println(findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
