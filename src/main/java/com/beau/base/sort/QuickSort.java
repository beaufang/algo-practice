package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class QuickSort {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int start, int end) {
        if (end <= start) return;
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    // 分区函数，把小的元素放左侧，大的元素放右侧
    private int partition(int[] arr, int start, int end) {
        // 选择最后一个元素作为 pivot
        int pivot = end;
        // 小于 pivot 的元素索引指针
        int i = start;
        // 将 pivot 放在数组的末尾
        // i 指针指向了比 pivot 大的元素，j 指针用于遍历整个数组
        // 当 arr[j] < arr[pivot] 时，交换 arr[i] 和 arr[j]
        // 最后将 pivot 放到数组中间
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[pivot]) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;
        return i;
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
