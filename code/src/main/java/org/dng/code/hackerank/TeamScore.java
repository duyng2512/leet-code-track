package org.dng.code.hackerank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamScore {

    public static List<Integer> counts(List<Integer> teamA, List<Integer> teamB) {
        Collections.sort(teamA);
        List<Integer> result = new ArrayList<>();
        for (Integer score : teamB) {
            result.add(binarySearch(score, teamA));
        }
        return result;
    }

    static public int binarySearch(int value, List<Integer> list) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (list.get(mid) == value) {
                return mid + 1;  // value element found at index mid
            } else if (list.get(mid) < value) {
                low = mid + 1;  // value element may be in the right half
            } else {
                high = mid - 1;  // value element may be in the low half
            }
        }
        return low;
    }

    public static void main(String[] args) {

        List<Integer> teamA = new ArrayList<>();
        teamA.add(1);
        teamA.add(2);
        teamA.add(3);

        List<Integer> teamB = new ArrayList<>();
        teamB.add(2);
        teamB.add(4);

        System.out.println(counts(teamA, teamB));

        teamA = new ArrayList<>();
        teamA.add(1);
        teamA.add(4);
        teamA.add(2);
        teamA.add(4);

        teamB = new ArrayList<>();
        teamB.add(3);
        teamB.add(5);

        System.out.println(counts(teamA, teamB));

        teamA = new ArrayList<>();
        teamA.add(2);
        teamA.add(10);
        teamA.add(5);
        teamA.add(4);
        teamA.add(8);

        teamB = new ArrayList<>();
        teamB.add(3);
        teamB.add(1);
        teamB.add(7);
        teamB.add(8);

        System.out.println(counts(teamA, teamB));
    }

}
