package org.dng.code.by_tag.stack;

import java.util.Stack;

public class RemovingStarsFromString {

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if (cur != '*') {
                stack.push(cur);
            } else {
                if (!stack.isEmpty()) stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

}
