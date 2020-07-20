package com.beau.nowcoder;

import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(reverseString(sc.nextLine()));
        }
    }

    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            sb.append(s.charAt(i));
            i--;
        }
        return sb.toString();
    }
}
