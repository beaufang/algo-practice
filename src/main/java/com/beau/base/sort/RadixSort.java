package com.beau.base.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class RadixSort {

    // maxDigit 表示待排序数组中最大元素的位数
    public void radixSort(int[] arr, int maxDigit) {
        int len = arr.length;
        if (len <= 1) return;
        int mod = 10;
        int div = 1;
        // 初始化桶
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }
        for (int i = 1; i <= maxDigit; i++, mod *= 10, div *= 10) {
            // 将元素放入到对应的桶中
            for (int a : arr) {
                // 321 % 100 / 10 = 2
                int index = (a % mod) / div;
                buckets.get(index).add(a);
            }
            // 将元素拷贝回原数组
            for (int j = 0, k = 0; j < buckets.size(); j++) {
                for (int e : buckets.get(j)) {
                    arr[k++] = e;
                }
                buckets.get(j).clear();
            }
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1, 16, 19, 96, 20, 78, 132, 156, 192, 178};
        radixSort(arr, 3);
        System.out.println(Arrays.toString(arr));
    }
}
