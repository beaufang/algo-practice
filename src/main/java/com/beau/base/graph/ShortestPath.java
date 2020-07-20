package com.beau.base.graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestPath {


    //假设起点为src, 终点为dst, 图以二维矩阵的形式存储，若 graph[i][j] == 0, 代表i,j不相连
    public int Dijkstra(int src, int dst, int[][] graph) {
        int n = graph.length; // 图顶点个数
        //visited 标记访问过的节点，防止回溯
        boolean[] visited = new boolean[n];
        Queue<Vertex> queue = new PriorityQueue<>();
        //将起点加入 queue
        queue.add(new Vertex(src, 0));
        while (!queue.isEmpty()) {
            Vertex t = queue.poll();
            //当前节点是终点，即可返回最短路径
            if (t.node == dst) return t.cost;
            //若当前节点已遍历过，跳过当前节点
            if (visited[t.node]) continue;
            //将当前节点标记成已遍历
            visited[t.node] = true;
            for (int i = 0; i < n; i++) {
                if (graph[t.node][i] != 0 && !visited[i]) {
                    queue.add(new Vertex(i, t.cost + graph[t.node][i]));
                }
            }
        }
        return -1;
    }

    //定义一个存储节点和离起点相应距离的数据结构
    static class Vertex implements Comparable<Vertex> {
        int node;
        int cost;

        public Vertex() {}

        public Vertex(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertex o) {
            return this.cost - o.cost;
        }
    }

}
