package com.beau.template;

import com.beau.common.Node;
import org.junit.Test;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/5
 */
public class BinBFS {

    public int binBfs(Node start, Node target) {
        if (start == target) return 0;
        Set<Node> q1 = new HashSet<>();
        Set<Node> q2 = new HashSet<>();
        Set<Node> visited = new HashSet<>();
        q1.add(start);
        q2.add(target);
        visited.add(start);
        visited.add(target);
        int step = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // 总是从较小的一端处理
            if (q1.size() > q2.size()) {
                Set<Node> temp = q1;
                q1 = q2;
                q2 = temp;
            }
            // 用于存储下一层的节点
            Set<Node> nextLevel = new HashSet<>();
            for (Node cur : q1) {

                if (cur.children == null) {
                    continue;
                }
                for (Node child : cur.children) {
                    if (q2.contains(child)) {
                        return  step + 1;
                    }
                    if (!visited.contains(child)) {
                        nextLevel.add(child);
                    }
                }
            }
            step++;
            // 注意是直接覆盖
            q1 = nextLevel;
            visited.addAll(nextLevel);
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
        System.out.println(binBfs(node, new Node()));
        System.out.println(binBfs(node, node));
        System.out.println(binBfs(node, node2));
        System.out.println(binBfs(node, node3));
    }
}
