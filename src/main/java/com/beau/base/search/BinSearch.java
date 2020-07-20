package com.beau.base.search;

public class BinSearch {

    public int binSearch(int[] a, int from, int toIndex, int e) {
        if (a == null || a.length == 0) {
            return - 1;
        }
        int low = from;
        int high = toIndex - 1; // 前开后闭
        while (low <= high) {
            int mid = ((high - low) >>> 1) + low; // 注意运算符优先级
            if (e < a[mid]) {
                high = mid - 1;
            } else if (a[mid] < e) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        // 没有找到，low 为数据应该插入的位置索引
        // 如果返回值为 -3，则从索引 2 起的元素都比查找值大
        return -(low + 1);
    }

    public static void main(String[] args) {
        BinSearch search = new BinSearch();
        int[] a = {1, 3, 5, 6, 7, 9};
        System.out.println(search.binSearch(a, 0, a.length, 5));
        System.out.println(search.binSearch(a, 0, a.length, 4));
    }
}
