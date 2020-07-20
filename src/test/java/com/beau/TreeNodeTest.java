package com.beau;

import com.beau.common.TreeNode;
import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/7/20
 */
public class TreeNodeTest {

    @Test
    public void testGenTree() {
        TreeNode treeNode = TreeNode.genTree(1, null, 2, null, null,  3);
        System.out.println(treeNode.right.left.val);
    }
}
