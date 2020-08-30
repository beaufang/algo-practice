package com.beau;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        int step = 1;
        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        Set<String> visited = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);
        visited.add(beginWord);
        visited.add(endWord);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            if (q1.size() > q2.size()) {
                Set<String> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : q1) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    char old = chs[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chs[i] = c;
                        String newWord = new String(chs);
                        if (wordSet.contains(newWord)) {
                            if (q2.contains(newWord)) return step + 1;
                            if (!visited.contains(newWord)) {
                                nextLevel.add(newWord);
                            }
                        }
                    }
                    chs[i] = old;
                }
            }
            step++;
            q1 = nextLevel;
            visited.addAll(nextLevel);
        }
        return 0;
    }

    @Test
    public void test() {
        System.out.println(ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hit", "hot", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(ladderLength("hit", "hot", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }
}
