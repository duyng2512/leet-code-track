package org.dng.code.by_tag.greedy;

import java.util.HashSet;
import java.util.Set;

public class OptimalPartitionString {

    /**
     * Given a string s, partition the string into one or more substrings such that
     * the characters in each substring are unique. That is, no letter appears in a
     * single substring more than once.
     *
     * Return the minimum number of substrings in such a partition.
     *
     * Note that each character should belong to exactly one substring in a partition.
     *
     *
     *
     * Example 1:
     *
     * Input: s = "abacaba"
     * Output: 4
     * Explanation:
     * Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
     * It can be shown that 4 is the minimum number of substrings needed.
     * Example 2:
     *
     * Input: s = "ssssss"
     * Output: 6
     * Explanation:
     * The only valid partition is ("s","s","s","s","s","s").
     */

    /**
     * IDEA:
     * <p>
     * At each given index, we want to get as much unique character as possible
     */

    static public int partitionString(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (set.contains(cur)) {
                ans++;
                set = new HashSet<>();
            }
            set.add(cur);
        }
        return ans + 1;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("abacaba")); // 4
        System.out.println(partitionString("ssssss")); // 6
    }
}
