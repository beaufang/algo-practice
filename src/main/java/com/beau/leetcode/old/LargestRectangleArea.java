package com.beau.leetcode.old;

import java.util.Stack;

// 84 柱状图中的最大矩形
public class LargestRectangleArea {


    /**
     * 扫描矩形，当矩形的高度出现下降时，说明以当前矩形高度作为高度的面积已经无法扩展，
     * 计算面积。利用栈的特性，实现这种延迟计算。
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        int max = 0, n = heights.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && (i  == n || heights[i] < heights[stack.peek()])) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, width * height);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        test01();
    }

    public static void test01() {
        LargestRectangleArea s = new LargestRectangleArea();
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(s.largestRectangleArea(arr));
    }
}
