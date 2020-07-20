package com.beau.base.graph;

public class UnDirectedGraph extends Graph{


    public UnDirectedGraph(int v) {
        super(v);
    }

    @Override
    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

}
