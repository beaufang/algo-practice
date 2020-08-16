package com.beau;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private char[][] board;
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, trie, list);
            }
        }
        return list;
    }

    int[][] D = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void dfs(int i, int j, Trie trie, List<String> list) {
        char origin = board[i][j];
        Trie node = trie.next[origin - 'a'];
        if (node == null) {
            return;
        }
        if (node.word != null) {
            list.add(node.word);
            node.word = null;
        }
        board[i][j] = '@';
        for (int[] d : D) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[0].length && board[newI][newJ] != '@') {
                dfs(newI, newJ, node, list);
            }
        }
        board[i][j] = origin;

    }

    static class Trie {
        private final Trie[] next;
        private String word;

        public Trie() {
            this.next = new Trie[26];
        }

        public void insert(String word) {
            Trie node = this;
            for (char c : word.toCharArray()) {
                if (node.next[c - 'a'] == null) {
                    node.next[c -'a'] = new Trie();
                }
                node = node.next[c - 'a'];
            }
            node.word = word;
        }
    }

    @Test
    public void test() {
        System.out.println(findWords(new char[][]{{'a', 'a'}}, new String[]{"aa"}));
        System.out.println(findWords(new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}},
                new String[]{"oath","pea","eat","rain"}));

        System.out.println(findWords(new char[][]{{'a','a'}},
                new String[]{"aaa"}));
    }
}
