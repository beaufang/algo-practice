package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/7/20
 */
public class BinaryTreeInorderTraversal {

    // 迭代解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (true) {
            goAlongLeftBranch(stack, root);
            if (stack.isEmpty()) {
                break;
            }
            TreeNode node = stack.pollLast();
            ans.add(node.val);
            root = node.right;
        }
        return ans;

    }

    private void goAlongLeftBranch(Deque<TreeNode> stack, TreeNode root) {
        while (root != null) {
            stack.addLast(root);
            root = root.left;
        }
    }

    // 递归解法
    List<Integer> ans = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) {
            return ans;
        }
        inorderTraversal(root.left);
        ans.add(root.val);
        inorderTraversal(root.right);
        return ans;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal solution = new BinaryTreeInorderTraversal();
        TreeNode treeNode = TreeNode.genTree(1, null, 2, null, null, 3);
        solution.inorderTraversal(treeNode);
    }
}
