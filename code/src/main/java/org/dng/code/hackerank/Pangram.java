package org.dng.code.hackerank;

import java.util.List;

public class Pangram {

    public static String isPangram(List<String> pangram) {

        StringBuilder result = new StringBuilder();
        int NUM_CHARS = 26;

        for (String string : pangram) {
            boolean[] isSeen = new boolean[NUM_CHARS];

            for (byte character : string.getBytes()) {
                if (character != ' ') {
                    isSeen[character - 97] = true;
                }
            }

            boolean isPangram = true;

            for (boolean value : isSeen) {
                if (!value) {
                    isPangram = false;
                    break;
                }
            }

            if (isPangram) result.append("1");
            else result.append("0");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        List<String> test1 = List.of("pack my box with five dozen liquor jugs", "this is not a pangram");
        String result1 = isPangram(test1);
        System.out.println(result1);

        test1 = List.of("we promptly judged antique ivory buckles for the next prize",
            "we promptly judged antique ivory buckles for the prizes",
            "the quick brown fox jumps over the lazy dog",
            "the quick brown fox jump over the lazy dog");
        result1 = isPangram(test1);
        System.out.println(result1);
    }

}
