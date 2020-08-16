package com.beau.leetcode.week2;

import com.beau.common.TreeNode;

import java.util.*;

/**
 * @author BeauFang
 * Date: 2020/8/15
 * 145 https://leetcode-cn.com/problems/binary-tree-postorder-traversal/
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            // 从前往后插入
            ans.addFirst(node.val);
            if (node.left != null) {
                stack.addLast(node.left);
            }
            if (node.right != null) {
                stack.addLast(node.right);
            }
        }
        return ans;
    }

    List<Integer> ans = new ArrayList<>();
    public List<Integer> postorderTraversal_1(TreeNode root) {
        if (root == null) return ans;
        postorderTraversal_1(root.left);
        postorderTraversal_1(root.right);
        ans.add(root.val);
        return ans;
    }
}
