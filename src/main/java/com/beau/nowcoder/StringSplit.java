package com.beau.nowcoder;

import java.util.Scanner;

public class StringSplit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                stringSplit(s, 8);
            }
        }
    }

    public static void stringSplit(String s, int len) {
        if (s.length() < len) {
            String str = padding(s, len);
            System.out.println(str);
        } else {
            String str = s;
            while (str.length() > len) {
                System.out.println(str.substring(0, len));
                str = str.substring(len);
            }
            str = padding(str, len);
            System.out.println(str);
        }


    }

    public static String padding(String s, int len) {
        if (s.length() >= len) return s;
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < len) {
            sb.append("0");
        }
        return sb.toString();
    }
}
