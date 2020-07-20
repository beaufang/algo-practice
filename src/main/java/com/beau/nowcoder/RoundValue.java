package com.beau.nowcoder;

import java.util.Scanner;

// 浮点数近似值
public class RoundValue {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            System.out.println(roundValue(s));
        }
    }

    public static int roundValue(String s) {
        String[] split = s.split("\\.");
        int num = Integer.parseInt(split[0]);
        if (split.length > 1 && Integer.parseInt(split[1].charAt(0) + "") >= 5) {
            num ++;
        }
        return num;
    }
}
