package com.beau.template;

import com.beau.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author BeauFang
 *Date: 2020/8/7
 */
public class DFS {


    public void dfs(Node node, LinkedList<Node> path, List<List<Node>> res) {
        // 根据实际情况调整终止条件
        if (node == null) {
            // 将决策结果加入集合
            res.add(new ArrayList<>(path));
            return;
        }
        if (node.children == null) {
            return;
        }
        // 横向遍历选择列表
        for (Node child : node.children) {
            // 扩展出一个子状态
            path.addLast(child);
            // 下探
            dfs(child, path, res);
            // 状态还原
            path.removeLast();
        }
    }
}
