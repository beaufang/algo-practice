package com.beau.base.tree;

import java.util.Stack;

public class BinTreeInOrderTraversal {

    // 递归版
    public static void inOrderTraversal_1(BinTreeNode root, ITreeVisit visit) {
        if (root == null) return;
        inOrderTraversal_1(root.leftChild, visit);
        visit.visit(root);
        inOrderTraversal_1(root.rightChild, visit);
    }

    // 迭代版本
    public static void inOrderTraversal_2(BinTreeNode root, ITreeVisit visit) {
        Stack<BinTreeNode> stack = new Stack<>();
        while (true) {
            goAlongLeftBranch(root, stack);
            if (stack.isEmpty()) break;
            root = stack.pop();
            visit.visit(root);
            root = root.rightChild;
        }

    }

    private static void goAlongLeftBranch(BinTreeNode root, Stack<BinTreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.leftChild;
        }
    }

}
