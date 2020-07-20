package com.beau.base.graph;

public class DirectedGraph extends Graph{


    public DirectedGraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int s, int t) {
        adj[s].add(t);
    }

}
