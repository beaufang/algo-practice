package com.beau.nowcoder;


import java.util.Scanner;

public class LastWordLength {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(lastWordLen(line));
    }

    public static int lastWordLen(String s) {
        String[] splits = s.split("\\s");
        return splits[splits.length -1].length();
    }
}
