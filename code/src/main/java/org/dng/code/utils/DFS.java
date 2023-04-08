package org.dng.code.utils;

import java.util.*;

public class DFS {

    static class GridDFS {
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix;
        boolean[][] seen;
        int height, length;

        public GridDFS(int[][] matrix) {
            this.matrix = matrix;
            this.length = matrix[0].length;
            this.height = matrix.length;
            this.seen = new boolean[height][length];
        }

        public List<int[]> getNeighbours(int[][] matrix, int[] node) {
            List<int[]> result = new ArrayList<>();
            for (int[] direction : directions) {
                int row = node[0] + direction[0];
                int col = node[1] + direction[1];
                if (col >= 0 && col < length && row >= 0 && row < height && matrix[row][col] == 1) {
                    result.add(new int[]{row, col});
                }
            }
            return result;
        }

        public void dfsTransversal() {

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < length; j++) {
                    int[] curNode = new int[]{i, j};

                    // If node is not visited and is island
                    if (!seen[i][j] && matrix[i][j] == 1) {
                        Stack<int[]> dfs = new Stack<>();
                        dfs.add(curNode);
                        seen[i][j] = true;
                        while (!dfs.isEmpty()) {
                            int[] popNode = dfs.pop();

                            for (int[] node : getNeighbours(matrix, popNode)) {
                                if (!seen[node[0]][node[1]]) {
                                    dfs.push(node);
                                    seen[node[0]][node[1]] = true;
                                }
                            }
                        }
                    }
                }
            }

        }

        public static void main(String[] args) {
            int[][] matrix = new int[][]{
                    {0, 1, 0, 0},
                    {0, 1, 0, 0},
                    {0, 0, 1, 0}
            };
            GridDFS dfs = new GridDFS(matrix);
            dfs.dfsTransversal();
        }
    }


    static class AdjListDFS {
        int vertices;
        List<List<Integer>> adjLists;
        ArrayList<Boolean> seen;

        public AdjListDFS(int vertices) {
            this.vertices = vertices;

            adjLists = new LinkedList<>();
            seen = new ArrayList<>();
            for (int i = 0; i < vertices; i++) {
                adjLists.add(new LinkedList<>());
                seen.add(false);
            }
        }

        public void addEdge(int source, int dest) {
            this.adjLists.get(source).add(dest);
        }

        public void dfsNode(int node) {
            Stack<Integer> stack = new Stack<>();
            stack.add(node);
            while (!stack.isEmpty()) {
                int pop = stack.pop();
                if (seen.get(pop)) continue;
                seen.set(pop, true);

                System.out.print(pop + " ");

                List<Integer> adjList = adjLists.get(pop);
                for (Integer adjNode : adjList) {
                    if (!seen.get(adjNode)) {
                        stack.push(adjNode);
                    }
                }
            }
        }

        public void dfsTransversal() {
            int count = 0;
            for (int i = 0; i < vertices; i++) {
                if (!seen.get(i)) {
                    dfsNode(i);
                    count++;
                    System.out.println();
                }
            }
            System.out.println("Total cluster: " + count);
        }

        public static void main(String[] args) {

            AdjListDFS dfs = new AdjListDFS(4);
            dfs.addEdge(0, 1);
            dfs.addEdge(1, 2);
            dfs.dfsTransversal();
        }
    }

}
