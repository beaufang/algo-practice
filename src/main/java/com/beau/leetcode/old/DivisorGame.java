package com.beau.leetcode.old;

/**
 * @author BeauFang
 * Date: 2020/7/24
 * 1025 https://leetcode-cn.com/problems/divisor-game/
 */
public class DivisorGame {

    public boolean divisorGame(int N) {
        return (N & 1) == 0;
    }
}
