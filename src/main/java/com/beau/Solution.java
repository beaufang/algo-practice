package com.beau;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] grid = new char[n][n];
        for (char[] g : grid) {
            Arrays.fill(g, '.');
        }
        List<List<String>> ans = new ArrayList<>();
        dfs(grid, n, 0, ans);
        return ans;

    }

    private void dfs(char[][] grid,int n, int level, List<List<String>> ans) {
        if (level == n) {
            List<String> list = new ArrayList<>();
            for (char[] chs : grid) {
                list.add(new String(chs));
            }
            ans.add(list);
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (!isValid(grid, level, i)) {
                continue;
            }
            grid[level][i] = 'Q';
            dfs(grid, n, level + 1, ans);
            grid[level][i] = '.';
        }
    }

    private boolean isValid(char[][] grid, int row, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (i != row && grid[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col -1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row -1, j = col + 1; i >= 0 && j < grid[0].length; i--, j++) {
            if (grid[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
}
