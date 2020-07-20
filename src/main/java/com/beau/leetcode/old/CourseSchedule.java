package com.beau.leetcode.old;

import java.util.LinkedList;
import java.util.Queue;

// 207 排课
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] graph = new boolean[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = true;
        }
        // 拓扑排序，计算 degree
        int[] degree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int j = 0; j < numCourses; j++) {
                if (graph[i][j]) {
                    degree[j]++;
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        int counter = 0;
        while (!queue.isEmpty()) {
            int t = queue.poll();
            counter++;
            for (int i = 0; i < numCourses; i++) {
               if (graph[t][i]) {
                   degree[i]--;
                   if (degree[i] == 0) {
                       queue.add(i);
                   }
               }
            }
        }
        return counter == numCourses;
    }

    class Graph {
        int v;
        LinkedList<Integer>[] adj;

        public Graph(int v) {
            this.v = v;
            adj = new LinkedList[v];
        }

        public void addEdge(int s, int t) {
            adj[s].add(t);
        }
    }
}
