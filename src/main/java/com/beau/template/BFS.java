package com.beau.template;

import com.beau.common.Node;
import org.junit.Test;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/5
 */
public class BFS {

    public int bfs(Node start, Node target) {
        Queue<Node> queue = new LinkedList<>();
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
                    queue.offer(child);
                    visited.add(child);
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void test() {
        Node node = new Node();
        node.children = new ArrayList<>();
        Node node2 = new Node();
        Node node3 = new Node();
        node.children.add(node2);
        node.children.add(node3);
        System.out.println(bfs(node, new Node()));
    }
}
