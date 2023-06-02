package org.dng.code.by_tag.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MiceAndCheese {
    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(Comparator.comparingInt(o -> (o[1] - o[0])));
        int len = reward1.length;
        for (int i = 0; i < len; i++) {
            heap.add(new int[]{reward1[i], reward2[i]});
        }

        int total = 0;
        for (int i = 0; i < k; i++) {
            total += heap.poll()[0];
        }

        while (!heap.isEmpty()) {
            total += heap.poll()[1];
        }

        return total;

    }

    public static void main(String[] args) {
        // Input: reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
        int[] arr1 = new int[]{1, 1, 3, 4};
        int[] arr2 = new int[]{4, 4, 1, 1};
        System.out.println(miceAndCheese(arr1, arr2, 2));
    }
}
