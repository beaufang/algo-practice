package com.beau.leetcode.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author BeauFang
 * Date: 2020/9/16
 */
public class _1115_PrintFooBarAlternately {

    class FooBar {
        private int n;
        private Lock lock = new ReentrantLock();
        private Condition foo = lock.newCondition();
        private Condition bar = lock.newCondition();
        private volatile boolean flag = false;


        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            lock.lock();
            try {
                for (int i = 0; i < n; i++) {
                    if (flag) {
                        foo.await();
                    }
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    flag = true;
                    bar.signal();
                }
            } finally {
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            lock.lock();
            try {
                for (int i = 0; i < n; i++) {
                    if (!flag) {
                        bar.await();
                    }
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    flag = false;
                    foo.signal();
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
