package com.beau.leetcode.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 554 砖墙
public class LeastBricks {

    public int leastBricks(List<List<Integer>> wall) {
        // map <sum, count>
        Map<Integer, Integer> map = new HashMap<>();
        // 逐行遍历，最大衔接数
        for (List<Integer> row : wall) {
            int sum = 0;
            // 最后一块砖不算
            for (int i=0; i < row.size() - 1; i++) {
                sum += row.get(i);
                if (map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                } else {
                    map.put(sum, 1);
                }
            }
        }
        int res = wall.size();
        for (int key : map.keySet()) {
            res = Math.min(res, wall.size() - map.get(key));
        }
        return res;
    }
}
