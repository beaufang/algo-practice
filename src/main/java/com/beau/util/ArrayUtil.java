package com.beau.util;

import java.util.Arrays;

/**
 * @author BeauFang
 * Date: 2020/8/5
 */
public class ArrayUtil {

    public static void print2DArray(int[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        sb.append("\r\n");
        for (int[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void print2DArray(char[][] arr) {
        StringBuilder sb = new StringBuilder("[");
        sb.append("\r\n");
        for (char[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

    public static void print2DArray(boolean[][] arr) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append("\r\n");
        for (boolean[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }


    public static <T> void print2DArray(T[][] arr ) {
        StringBuilder sb = new StringBuilder("[ ");
        sb.append("\r\n");
        for (Object[] a : arr) {
            sb.append(Arrays.toString(a)).append("\r\n");
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }

}
