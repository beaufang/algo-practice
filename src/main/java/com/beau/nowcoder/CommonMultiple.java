package com.beau.nowcoder;

import java.util.Scanner;

/**
 * 最小公倍数
 */
public class CommonMultiple {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(m * n / highestCommonFactor(m, n));
        }
    }

    /**
     * 最大公约数
     * @param m
     * @param n
     * @return
     */
    public static int highestCommonFactor(int m, int n) {
        if (m < n) {
            int tmp = m;
            m = n;
            n = tmp;
        }
        while (m % n != 0) {
            int k = m % n;
            m = n;
            n = k;
        }
        return n;
    }
}
