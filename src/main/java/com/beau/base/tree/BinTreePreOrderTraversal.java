package com.beau.base.tree;

import java.util.Stack;

public class BinTreePreOrderTraversal {

    // 递归版
    public static void preOrderTraversal_1(BinTreeNode root, ITreeVisit visit) {
        if (root == null) return;
        visit.visit(root);
        preOrderTraversal_1(root.leftChild, visit);
        preOrderTraversal_1(root.rightChild, visit);
    }

    // 迭代版
    public static void preOrderTraversal_2(BinTreeNode root, ITreeVisit visit) {
        Stack<BinTreeNode> stack = new Stack<>();
        while (true) {
            visitAlongLeftBranch(root, stack, visit);
            if (stack.isEmpty()) break;
            root = stack.pop();
        }

    }

    private static void visitAlongLeftBranch(BinTreeNode root, Stack<BinTreeNode> stack, ITreeVisit visit) {
        while (root != null) {
            visit.visit(root);
            stack.push(root.rightChild);
            root = root.leftChild;
        }
    }
}
