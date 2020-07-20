package com.beau.leetcode.old;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {

    public boolean isValid(String s) {
        if (s == null) return false;
        if (s.length() == 0) return true;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if ( stack.isEmpty() || !(map.get(s.charAt(i)).equals(stack.pop()))) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        ValidBracket v = new ValidBracket();
        System.out.println(v.isValid("()[]{}"));
    }
}
