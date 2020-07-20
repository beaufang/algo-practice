package com.beau.nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberTrans {
    static Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('A', 10);
        map.put('B', 11);
        map.put('C', 12);
        map.put('D', 13);
        map.put('E', 14);
        map.put('F', 15);
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(trans(s));
        }
    }

    public static int trans(String s) {
        int res = 0;
        int pos = 0;
        String str = s.replace("0x","");
        while (pos < str.length()) {
            res += Math.pow(16, pos) * map.get(str.charAt(str.length() - pos - 1));
            pos ++;
        }
        return res;
    }
}
