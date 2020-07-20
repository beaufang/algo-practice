package com.beau.common;

public class Fib {

    private int f = 0;
    private int g = 1;

    public Fib(int n) {
        while (g < n) {
            next();
        }
    }

    /**
     * 获取不小于 n 的 斐波那契数
     * @return
     */
    public int get() {
        return g;
    }

    public int next() {
        g += f;
        f = g - f;
        return g;
    }

    public int prev() {
        f = g - f;
        g -= f;
        return g;
    }

    public static void main(String[] args) {
        Fib fib = new Fib(3);
        System.out.println(fib.get());
        System.out.println(fib.prev());
    }
}
