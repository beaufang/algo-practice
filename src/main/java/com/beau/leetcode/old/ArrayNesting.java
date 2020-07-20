package com.beau.leetcode.old;

import java.util.HashSet;
import java.util.Set;

// 565 数组嵌套
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        // 优化思路：记录已近处理过的index,因为后面的 index 肯定比第一个遇到该 index 的长度小
        // 进一步优化：内部的 set 实际上可以不要。可以从路径连通性上面考虑
        // 再进一步优化：直接用数组标记
        // 再进一步：不使用新数据，直接标记原始数组
        int max = 0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int count = 1;
                int next = nums[i];
                nums[i] = Integer.MAX_VALUE;
                while(nums[next] != Integer.MAX_VALUE) {
                    count++;
                    int tmp = next;
                    next = nums[next];
                    nums[tmp] = Integer.MAX_VALUE;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int arrayNesting4(int[] nums) {
        // 优化思路：记录已近处理过的index,因为后面的 index 肯定比第一个遇到该 index 的长度小
        // 再一步优化：内部的 set 实际上可以不要。可以从路径连通性上面考虑
        // 再进一步优化：直接用数组标记
        int max = 0;
        boolean[] visited = new boolean[nums.length];
        for (int num : nums) {
            if (!visited[num]) {
                visited[num] = true;
                int count = 1;
                int next = nums[num];
                while (!visited[next]) {
                    count++;
                    visited[num] = true;
                    next = nums[next];
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }



    public int arrayNesting3(int[] nums) {
        // 优化思路：记录已近处理过的index,因为后面的 index 肯定比第一个遇到该 index 的长度小
        // 进一步优化：内部的 set 实际上可以不要。可以从路径连通性上面考虑
        int max = 0;
        Set<Integer> memo = new HashSet<>();
        for (int num : nums) {
            if (!memo.contains(num)) {
                memo.add(num);
                int count = 1;
                int next = nums[num];
                while (!memo.contains(next)) {
                    count++;
                    memo.add(next);
                    next = nums[next];
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    public int arrayNesting2(int[] nums) {
        // 优化思路：记录已近处理过的index,因为后面的 index 肯定比第一个遇到该 index 的长度小
        int max = 0;
        Set<Integer> memo = new HashSet<>();
        for (int num : nums) {
            if (!memo.contains(num)) {
                Set<Integer> set = new HashSet<>();
                set.add(num);
                int count = 1;
                int next = nums[num];
                while (!set.contains(next)) {
                    count++;
                    set.add(next);
                    memo.add(next);
                    next = nums[next];
                }
                if (count > max) {
                    max = count;
                }
            }
        }

        return max;
    }


    public int arrayNesting1(int[] nums) {
        int max = 0;
        for (int num : nums) {
            Set<Integer> set = new HashSet<>();
            set.add(num);
            int count = 1;
            int next = nums[num];
            while (!set.contains(next)) {
                count++;
                set.add(next);
                next = nums[next];
            }
            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayNesting s = new ArrayNesting();
        int[] A = {5, 4, 0, 3, 1, 6, 2};
//        int[] A = {5};
        int nesting = s.arrayNesting(A);
        System.out.println(nesting);
    }

}
