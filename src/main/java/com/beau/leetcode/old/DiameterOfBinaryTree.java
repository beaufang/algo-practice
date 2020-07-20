package com.beau.leetcode.old;

import com.beau.common.TreeNode;

// 543 二叉树的直径
public class DiameterOfBinaryTree {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int L = depth(node.left);
        int R = depth(node.right);
        ans = Math.max(ans, R+L+1);
        return Math.max(R, L) + 1;
    }

}
