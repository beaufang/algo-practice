package com.beau.common;

import java.util.List;

/**
 * @author BeauFang
 * Date: 2020/7/20
 * 多叉树树节点
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
