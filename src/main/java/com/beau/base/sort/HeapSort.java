package com.beau.base.sort;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class HeapSort {

    public void heapSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int a : arr) {
            pq.add(a);
        }
        for (int i = 0; i < len; i++) {
            arr[i] = pq.poll();
        }
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
