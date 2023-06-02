package org.dng.code.by_tag.topological_sort;

import java.util.*;

public class LargestColorValueInDirectedGraph {

    public int largestPathValue(String colors, int[][] edges) {

        int numOfVertices = colors.length();
        int answer = 0;

        List<List<Integer>> adjList = new ArrayList<>();
        Map<Character, Integer> countMap = new HashMap<>();

        for (int i = 0; i < colors.length(); i++) {
            char color = colors.charAt(i);
            countMap.put(color, 0);
        }

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

            char color = colors.charAt(curNode);
            countMap.put(color, countMap.get(color) + 1);
            answer = Math.max(answer, countMap.get(color));

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
            return -1;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
        System.out.println();

        return answer;
    }

}
