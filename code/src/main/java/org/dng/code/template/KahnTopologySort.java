package org.dng.code.template;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class KahnTopologySort {
    public static void main(String[] args) {
        KahnTopologySort kahnTopologySort = new KahnTopologySort();
        int[][] edge = new int[][]{{0, 1}, {0, 2}, {2, 3}, {3, 4}};
        kahnTopologySort.topologicalSort(5, edge);
        kahnTopologySort.topologicalSort(1, new int[][]{{0, 0}});
    }

    public void topologicalSort(int numOfVertices, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();

        // Build up adjList
        for (int i = 0; i < numOfVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // From edges
        for (int[] edge : edges) {
            int source = edge[0];
            int dest = edge[1];
            adjList.get(source).add(dest);
        }

        // Count freq of vertices
        int[] inDegree = new int[numOfVertices];

        // Find the top order vertices, count the number of edge enter this node
        for (int i = 0; i < numOfVertices; i++) {
            for (Integer node : adjList.get(i)) {
                inDegree[node]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numOfVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Count num of visited vertices
        int count = 0;
        List<Integer> topOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            topOrder.add(curNode);

            // Iterate neighbours node
            for (Integer neighbour : adjList.get(curNode)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
            count++;
        }

        if (count != numOfVertices) {
            System.out.println("There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
