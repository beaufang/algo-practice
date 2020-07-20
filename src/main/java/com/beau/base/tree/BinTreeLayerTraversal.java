package com.beau.base.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinTreeLayerTraversal {

    public static void layerTraversal_1(BinTreeNode root, ITreeVisit visit) {
        Queue<BinTreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinTreeNode node = queue.poll();
            visit.visit(node);
            if (node.leftChild != null) {
                queue.add(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.add(node.rightChild);
            }
        }
    }

}
