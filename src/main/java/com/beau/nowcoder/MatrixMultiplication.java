package com.beau.nowcoder;

import java.util.Arrays;
import java.util.Scanner;

// TODO UNDONE
public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = Integer.parseInt(sc.nextLine());
            int y = Integer.parseInt(sc.nextLine());
            int z = Integer.parseInt(sc.nextLine());
            String[][] A = new String[x][y];
            String[][] B = new String[y][z];
            for (int i = 0; i < x; i++) {
                A[i] = sc.nextLine().split("\\s");
            }

            for (int i = 0; i < y; i++) {
                B[i] = sc.nextLine().split("\\s");
            }
            multiply(A, B);
        }
    }

    private static void multiply(String[][] a, String[][] b) {
//        int[][] R = new int[a.length][b[0].length];
        int[] R = new int[b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < b[0].length; k++) {
                int c = 0;
                for (int j = 0; j < a[0].length; j++) {
                    int v = Integer.valueOf(a[i][j]) * Integer.valueOf(b[j][k]);
                    c += v;
                }
                R[k] = c;
            }
            System.out.println(Arrays.toString(R).replace("[", "").replace("]", ""));
        }
    }
}
