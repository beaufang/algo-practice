package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class CountingSort {

    public void countingSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        // 查找最大值和最小值
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        // 计数数组
        int[] c = new int[max - min + 1];
        // 统计元素个数
        for (int a : arr) {
            c[a - min]++;
        }
        // 拷贝回原数组
        for (int i = 0, j = 0; i < c.length; i++) {
            while (c[i] > 0) {
                // 注意这里是索引 i + min
                arr[j++] = i + min;
                c[i]--;
            }
        }
    }


    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
