package org.dng.code.by_tag.simulation;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SpiralMatrixII {

    int[][] dir = new int[][]{
        {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) {

        SpiralMatrixII matrixII = new SpiralMatrixII();
        int[][] res = matrixII.generateMatrix(4);
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.
     * <p>
     * Input: n = 3
     * Output: [[1,2,3],[8,9,4],[7,6,5]]
     */

    public int[][] generateMatrix(int n) {

        if (n == 1) {
            return new int[][]{{1}};
        }

        int count = 0;
        int[] cur = new int[]{0, 0};
        int MAX = n * n;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        AtomicInteger dirCount = new AtomicInteger();
        while (count < MAX) {
            result[cur[0]][cur[1]] = count + 1;
            cur = getNextCell(result, cur, dirCount, n);
            count++;
        }
        return result;
    }

    public int[] getNextCell(int[][] arr, int[] cur, AtomicInteger dirCount, int N) {

        if ((cur[0] == 0 && cur[1] == N - 1) ||
            (cur[0] == N - 1 && cur[1] == N - 1) ||
            (cur[0] == N - 1 && cur[1] == 0)) {
            dirCount.incrementAndGet();
            if (dirCount.intValue() == dir.length) {
                dirCount.set(0);
            }
        }

        int newX = cur[0] + dir[dirCount.get()][0];
        int newY = cur[1] + dir[dirCount.get()][1];

        if (arr[newX][newY] != -1) {
            dirCount.incrementAndGet();
            if (dirCount.intValue() == dir.length) {
                dirCount.set(0);
            }
        }
        cur[0] = cur[0] + dir[dirCount.get()][0];
        cur[1] = cur[1] + dir[dirCount.get()][1];
        return cur;
    }

}
