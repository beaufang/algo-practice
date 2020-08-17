package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class InsertionSort {

    public void insertionSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        int temp;
        // 挑选一个元素，插入到已排序区间
        for (int i = 1; i < len; i++) {
            temp = arr[i];
            int j = i - 1;
            // 寻找插入位置
            while (j >= 0 && temp < arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
