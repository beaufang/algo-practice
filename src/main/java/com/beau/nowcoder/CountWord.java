package com.beau.nowcoder;

import java.util.Scanner;

public class CountWord {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String p = in.nextLine();
        System.out.println(counter(line, p));
    }

    static int counter(String line, String p) {
        int counter = 0;
        for (int i=0; i<line.length(); i++) {
            if (String.valueOf(line.charAt(i)).equalsIgnoreCase(p)) {
                counter++;
            }
        }
        return counter;
    }
}
