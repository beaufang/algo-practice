package com.beau.base.tree;

import com.beau.common.INode;

public class BinTreeNode<T> implements INode {
    public T data;
    public BinTreeNode<T> leftChild;
    public BinTreeNode<T> rightChild;
    public BinTreeNode<T> parent;

    public static <D> BinTreeNode genTreeByLayer(D[] datas) {
        if (datas == null || datas.length == 0) {
            return null;
        }
        BinTreeNode root = new BinTreeNode();
        root.data = datas[0];
        BinTreeNode[] queue = new BinTreeNode[datas.length];
        queue[0] = root;
        for (int i = 1; i < datas.length; i++) {
            BinTreeNode parent;
            BinTreeNode node = null;
            if (datas[i] != null) {
                node = new BinTreeNode();
                node.data = datas[i];
            }
            queue[i] = node;
            if (i % 2 == 1) {
                parent = queue[(i - 1) / 2];
                if ( parent != null) {
                    parent.leftChild = node;
                }
            } else {
                parent = queue[(i - 2) / 2];
                if (parent != null) {
                    parent.rightChild = node;
                }
            }
            if (node != null) {
                node.parent = parent;
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Integer[] arr = {3, 4, 5, null, 6, 8, 9, null, null, 9};
        BinTreeNode binTreeNode = genTreeByLayer(arr);
        System.out.println(binTreeNode.rightChild.leftChild.data);
    }

    @Override
    public T data() {
        return this.data;
    }
}
