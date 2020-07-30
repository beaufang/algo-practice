package com.beau;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author BeauFang
 * Date: 2020/7/20
 */
public class TreeNodeTest {

    public int robotSim(int[] commands, int[][] obstacles) {
        int ans = 0;
        Set<String> set = new HashSet<>();
        for (int[] o : obstacles) {
            set.add(o[0] + "," + o[1]);
        }
        int direction = 0;
        int x = 0, y = 0;
        // 北东南西
        int[][] arr = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for (int com : commands) {
            if (com > 0) {
                for (int i = 0; i < com; i++) {
                    int nextX = x + arr[direction][0];
                    int nextY = y + arr[direction][1];
                    if (set.contains(nextX + "," + nextY)) {
                        break;
                    }
                    x = nextX;
                    y = nextY;
                    ans = Math.max(ans, x * x + y * y);
                }
            } else if (com == -1) {
                direction = (direction + 1) % 4;
            } else {
                direction = (direction + 3) % 4;
            }
        }
        return ans;
    }

    @Test
    public void test() {
        robotSim(new int[]{4,-1,3}, new int[][]{});
    }
}
