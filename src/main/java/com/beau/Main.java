package com.beau;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        long fillStart = System.currentTimeMillis();
        Map<Integer, Integer> map = new HashMap<>();
        int size = 1000000;
        for (int i = 0; i < size; i++) {
            map.put(i, i);
        }
        System.out.println("===== start ======");
       long start = System.currentTimeMillis();
        int counter = 0;
        Random random = new Random(size);
        StringBuilder sb = new StringBuilder();
        while (counter < size) {
            map.get(random.nextInt() % size);
            long x = counter * random.nextInt();
            sb.append(counter).append(":");
            counter++;
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(System.currentTimeMillis() - fillStart);

    }




}
