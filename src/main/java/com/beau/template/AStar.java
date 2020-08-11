package com.beau.template;

import com.beau.common.Node;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/11
 */
public class AStar {

    public int search(Node start, Node target) {
        // 使用优先级队列，根据优先级搜索
        PriorityQueue<Node> queue = new PriorityQueue<>();
        Set<Node> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node node = queue.poll();
                if (node == target) {
                    return step;
                }
                if (node.children == null) {
                    continue;
                }
                for (Node child : node.children) {
                    int score = heuristic(node, target);
//                    child.score = score;
                    queue.offer(child);
                    visited.add(child);
                }
            }
            step++;
        }
        return -1;
    }

    // 估价函数
    private int heuristic(Node node, Node target) {
        // 通常可以使用曼哈顿距离、汉明距离等计算节点的价值
        return 0;
    }
}
