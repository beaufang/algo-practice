package com.beau.base.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/8/17
 */
public class BucketSort {

    public void bucketSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) return;
        int max = arr[0], min = arr[0];
        for (int a : arr) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        // 每个桶中的元素区间为[a, a + step)
        int step = 10;
        int bucketNum = (max - min) / step + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 1; i <= bucketNum; i++) {
            buckets.add(new ArrayList<>());
        }
        // 把元素压入桶中
        for (int a : arr) {
            // 获取元素所属的桶的索引
            int index = indexFor(a, min, step);
            buckets.get(index).add(a);
        }
        // 分别对每个桶排序，然后把元素存入原数组
        for (int i = 0, index = 0; i < bucketNum; i++) {
            Collections.sort(buckets.get(i));
            for (int k : buckets.get(i)) {
                arr[index++] = k;
            }
        }
    }

    private int indexFor(int a, int min, int step) {
        return (a - min) / step;
    }

    @Test
    public void test() {
        int[] arr = {6, 9, 0, 3, 3, 2, 4, 1};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
