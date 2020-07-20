package com.beau.base.search;

import com.beau.common.Fib;

public class FibSearch {

    public int fibSearch(int[] a, int from, int toIndex, int e) {
        int low = from;
        int high = toIndex - 1;
        Fib fib = new Fib(high - low); // 生成斐波那契数列
        while (low < high) {
            while (high - low < fib.get()) {
                fib.prev();
            }
            // 黄金切分点
            int mid = low + fib.get() - 1;
            if ( e < a[mid]) {
                high = mid - 1;
            } else if ( a[mid] < e) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    public static void main(String[] args) {
        FibSearch search = new FibSearch();
        int[] a = {1, 3, 5, 6, 7, 9};
        System.out.println(search.fibSearch(a, 0, a.length, 5));
        System.out.println(search.fibSearch(a, 0, a.length, 4));
    }
}
