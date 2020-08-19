package com.beau.leetcode.week5;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/13
 * 433 https://leetcode-cn.com/problems/minimum-genetic-mutation/
 */
public class MinimumGeneticMutation {

    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) return -1;
        int step = 0;
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q1.add(start);
        q2.add(end);
        visited.add(start);
        visited.add(end);
        char[] genes = {'A', 'C', 'G', 'T'};
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String c : q1) {
                char[] chs = c.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char g : genes) {
                        if (old == g) continue;
                        chs[i] = g;
                        String newStr = new String(chs);
                        if (q2.contains(newStr)) return step+1;
                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                            nextLevel.add(newStr);
                        }
                    }
                    chs[i] = old;
                }
            }
            step++;
            q1 = nextLevel;
            visited.addAll(nextLevel);
        }
        return -1;
    }

    public int minMutation2(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(end)) {
            return -1;
        }
        int step = 0;
        char[] genes = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] chs = queue.poll().toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c : genes) {
                        if (c == old) {
                            continue;
                        }
                        chs[j] = c;
                        String newString = new String(chs);
                        if (!visited.contains(newString) && bankSet.contains(newString)) {
                            queue.offer(newString);
                            visited.add(newString);
                            if (newString.equals(end)) {
                                return step + 1;
                            }
                        }
                    }
                    chs[j] = old;
                }
            }
            step++;
        }
        return -1;
    }
}
