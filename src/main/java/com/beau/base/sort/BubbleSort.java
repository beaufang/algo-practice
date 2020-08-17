package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        for (int i = 0; i < len; i++) {
            // 提前退出冒泡循环的标志位, false 表示没有数组交换
            boolean flag = false;
            for (int j = 0; j < len - 1; j++) {
                // 大了做交换
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            // 这一趟比较下来，没有数据交换，就退出
            if(!flag) break;
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
