package com.beau.util;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/5
 */
public class ArrayUtil {

    public static void print2DArray(int[][] arr) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void print2DArray(boolean[][] arr) {
        StringBuilder sb = new StringBuilder("[ ");
        for (boolean[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        System.out.println(sb.toString());
    }


    public static <T> void print2DArray(T[][] arr ) {
        StringBuilder sb = new StringBuilder("[ ");
        for (Object[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.setLength(sb.length() - 2);
        sb.append(" ]");
        System.out.println(sb.toString());
    }

}
