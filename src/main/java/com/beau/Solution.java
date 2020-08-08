package com.beau;

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        int step = 1;
        queue.add(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> nextLevel = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] chs = word.toCharArray();
                for(int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chs[j] = c;
                        String newWord = new String(chs);
                        if (!visited.contains(newWord) && wordSet.contains(newWord)) {
                            if (endWord.equals(newWord)) {
                                return step + 1;
                            }
                            if (!nextLevel.contains(newWord)) {
                                queue.offer(newWord);
                                nextLevel.add(newWord);
                            }
                        }
                    }
                    chs[j] = old;
                }
            }
            visited.addAll(nextLevel);
            step++;
        }
        return 0;
    }
}
