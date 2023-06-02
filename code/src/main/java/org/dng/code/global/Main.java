package org.dng.code.global;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {

    // Heap sort by first startI
    // ON(logN)
    // On => OnLogN Time

    // Space: O(n)

    public static List<int[]> execute(List<int[]> input) {


        // Build a heap
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        queue.addAll(input);

        List<int[]> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int[] pop = queue.poll();
            if (result.isEmpty()) result.add(pop);
            else {

                // Check overlap
                int[] lastElement = result.get(result.size() - 1);
                if (lastElement[1] > pop[0]) { // overlap then merge
                    // new
                    int[] newElement = new int[]{lastElement[0], pop[1]};
                    result.set(result.size() - 1, newElement);
                } else {
                    result.add(pop);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1, 3});
        list.add(new int[]{2, 6});
        list.add(new int[]{8, 10});
        list.add(new int[]{15, 18});

        List<int[]> result = execute(list);
        result.forEach(e -> System.out.println(e[0] + " " + e[1]));

    }

}
