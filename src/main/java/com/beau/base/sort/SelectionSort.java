package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            // 找出待排序区间中最小的元素
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
