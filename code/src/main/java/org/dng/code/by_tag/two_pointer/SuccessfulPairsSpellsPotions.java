package org.dng.code.by_tag.two_pointer;

import java.util.Arrays;

public class SuccessfulPairsSpellsPotions {

    static public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int spell = spells[i];
            long minPotion = (long) Math.ceil((1.0 * success) / spell);
            int index = potions.length - smallestGreaterThanTarget(potions, minPotion);
            spells[i] = index;
        }
        return spells;
    }

    public static int smallestGreaterThanTarget(int[] arr, long target) {
        if (arr[arr.length - 1] < target) return arr.length;
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

}
