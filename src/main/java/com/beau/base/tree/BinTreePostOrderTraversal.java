package com.beau.base.tree;

import java.util.Stack;

public class BinTreePostOrderTraversal {

    // 递归版
    public static void postOrderTraversal_1(BinTreeNode root, ITreeVisit visit) {
        if (root == null) return;
        postOrderTraversal_1(root.leftChild, visit);
        postOrderTraversal_1(root.rightChild, visit);
        visit.visit(root);
    }

    // 迭代版
    public static void postOrderTraversal_2(BinTreeNode root, ITreeVisit visit) {
        Stack<BinTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            // 当前节点为左节点
            if (root.parent != stack.peek()) {
                goHLVFL(stack);
            }
            root = stack.pop();
            visit.visit(root);
        }
    }

    // high leaf visible from left
    private static void goHLVFL(Stack<BinTreeNode> stack) {
        BinTreeNode node;
        while ((node = stack.peek()) != null) {
            if (node.leftChild != null) { // 优先沿左侧
                // 因为遍历顺序，先左侧，所以优先入栈右节点
                if (node.rightChild != null) stack.push(node.rightChild);
                stack.push(node.leftChild);
            }else {
                stack.push(node.rightChild);
            }
        }
        // 将栈顶 null 节点弹出
        stack.pop();
    }
}
