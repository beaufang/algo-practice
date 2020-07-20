package com.beau.base.graph;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public abstract class Graph {

    protected int v; // 顶点个数
    protected LinkedList<Integer>[] adj; // 邻接表

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        // 这种每个数组填充的是一个对象
//        Arrays.fill(adj, new LinkedList<>());
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public abstract void addEdge(int s, int t);


    // 搜索 s 到 t 的路径
    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        queue.add(s);
        while (!queue.isEmpty()) {
            int w = queue.poll();
            for (int q : adj[w]) {
                if (visited[q]) continue;
                prev[q] = w;
                if (q == t) {
                    // 输出路径
                    print(prev, s, t);
                    return;
                }
                visited[q] = true;
                queue.add(q);
            }
        }
    }

    // 深度优先搜索 s 到 t 的路径
    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        int[] prev = new int[v];
        Arrays.fill(prev, -1);
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
    }

    private void recurDfs(int s, int t, boolean[] visited, int[] prev) {
        visited[s] = true;
        if (s == t) return;
        for (int q : adj[s]) {
            if (visited[q]) continue;
            prev[q] = s;
            recurDfs(q, t, visited, prev);
        }
    }


    // 打印 s -> 的路径
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && s != t) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    // 拓扑排序
    public String topologySort() {
        // 计算每个节点的入度
        int[] degree = new int[v];
        for (int i = 0; i < v; i++) {
            for (int p : adj[i]) {
                degree[p]++;
            }
        }
        // 用队列存储入度为 0 的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int counter = 0;
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()) {
            int t = queue.poll();
            res.append(t);
            res.append("->");
            counter++;
            // 更新其他节点的入度
            for (int p : adj[t]) {
                degree[p]--;
                if (degree[p] == 0) {
                    queue.add(p);
                }
            }
        }
        // 所有节点遍历完毕
        if (counter == v) {
            return res.toString().substring(0, res.length() - 2);
        }
        // 存在环
        return null;

    }

    public void printGraph() {
        System.out.println(JSON.toJSONString(adj, true));
    }
}
