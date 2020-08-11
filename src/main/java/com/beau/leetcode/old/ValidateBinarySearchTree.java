package com.beau.leetcode.old;

import com.beau.common.TreeNode;

/**
 * @author BeauFang
 * Date: 2020/8/11
 * 98 https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    // 需要使用 long, 因为节点会取到 int 的最小值
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = isValidBST(root.left);
        if (pre >= root.val) {
            return false;
        }
        pre = root.val;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
