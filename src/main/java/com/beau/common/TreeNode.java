package com.beau.common;

/**
 * @author BeauFang
 * Date: 2020/7/20
 */
public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public static TreeNode genTree(Integer... vals) {
        if (vals == null || vals.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(vals[0]);
        TreeNode[] queue = new TreeNode[vals.length];
        queue[0] = root;
        for (int i = 1; i < vals.length; i++) {
            TreeNode node = null;
            if (vals[i] != null) {
                node = new TreeNode(vals[i]);
            }
            queue[i] = node;
            TreeNode parent = queue[(i - 1) / 2];
            if (parent == null) {
                continue;
            }
            if ((i & 1) == 1) {
                parent.left = node;
            } else {
                parent.right = node;
            }

        }
        return root;
    }
}
