package com.beau.leetcode.concurrent;

import java.util.function.IntConsumer;

/**
 * @author BeauFang
 * Date: 2020/9/16
 */
public class _1116_PrintZeroEvenOdd {

    class ZeroEvenOdd {

        private static final int STATE_ZERO = 0;
        private static final int STATE_ODD = 1;
        private static final int STATE_EVEN = 2;
        private int n;
        private Object lock = new Object();
        // 根据 state 判断，可以执行哪个打印
        private int state = STATE_ZERO;
        // flag 为 true 的时候，可以打印奇数，否则可以打印偶数
        private boolean flag = true;


        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            synchronized (lock) {
                for (int i = 0; i < n; i++) {
                    while (state != STATE_ZERO) {
                        lock.wait();
                    }
                    printNumber.accept(0);
                    state = flag ? STATE_ODD : STATE_EVEN;
                    lock.notifyAll();

                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            synchronized (lock) {
                for (int i = 2; i <= n; i += 2) {
                    while (state != STATE_EVEN) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = STATE_ZERO;
                    flag = true;
                    lock.notifyAll();
                }
            }

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            synchronized (lock) {
                for (int i = 1; i <= n; i+= 2) {
                    while (state != STATE_ODD) {
                        lock.wait();
                    }
                    printNumber.accept(i);
                    state = STATE_ZERO;
                    flag = false;
                    lock.notifyAll();
                }
            }
        }
    }


    class ZeroEvenOdd2 {
        private int n;
        // 当前打印的状态
        private volatile int state = 0;
        // 下一个是否可以打印奇数
        private volatile boolean control = true;

        public ZeroEvenOdd2(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                while (state != 0) {
                    Thread.yield();
                }
                printNumber.accept(0);
                if (control) {
                    state = 1;
                } else {
                    state = 2;
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                while (state != 2) {
                    Thread.yield();
                }
                printNumber.accept(i);
                control = true;
                state = 0;
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                while (state != 1) {
                    Thread.yield();
                }
                printNumber.accept(i);
                control = false;
                state = 0;
            }
        }
    }
}
