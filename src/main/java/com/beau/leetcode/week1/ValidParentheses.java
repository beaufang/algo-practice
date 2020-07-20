package com.beau.leetcode.week1;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 20 https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!stack.pollLast().equals(map.get(c))) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
