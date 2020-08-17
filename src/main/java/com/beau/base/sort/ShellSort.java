package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class ShellSort {

    public void shellSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        int temp;
        // 选取步长
        for (int step = len / 2; step >= 1; step /= 2) {
            // 选择插入元素
            for (int i = step; i < len; i++) {
                temp = arr[i];
                int j = i - step;
                // 查找插入位置
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
