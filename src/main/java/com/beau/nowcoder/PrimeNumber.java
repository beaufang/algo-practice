package com.beau.nowcoder;

import java.util.Scanner;

public class PrimeNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            long n = Long.parseLong(sc.nextLine());
            System.out.println(primeNumber(n));
        }
    }

    public static String primeNumber(long n) {
        StringBuilder sb = new StringBuilder();
        int index = 2;
        while (n >= index) {
            if (n % index == 0) {
                sb.append(index).append(" ");
                n = n / index;
            } else {
                index++;
            }
        }
        return sb.toString();
    }
}
