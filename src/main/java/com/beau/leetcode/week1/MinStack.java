package com.beau.leetcode.week1;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 20  https://leetcode-cn.com/problems/min-stack/
 */
public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int x) {
        stack.addLast(x);
        // 注意取等号
        if (minStack.isEmpty() || minStack.peekLast() >= x) {
            minStack.addLast(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        if (stack.pollLast().equals(minStack.peekLast())) {
            minStack.pollLast();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return stack.peekLast();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return minStack.peekLast();
    }

}
