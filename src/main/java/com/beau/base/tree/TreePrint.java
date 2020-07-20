package com.beau.base.tree;

import com.beau.common.INode;

public class TreePrint implements ITreeVisit {

    @Override
    public void visit(INode node) {
        System.out.println(node.data());
    }
}
