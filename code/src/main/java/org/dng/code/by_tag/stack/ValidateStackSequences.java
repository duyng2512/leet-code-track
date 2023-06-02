package org.dng.code.by_tag.stack;

import java.util.Stack;

public class ValidateStackSequences {

    static public boolean validateStackSequences(int[] pushed, int[] popped) {

        // 1 2 3 4 5
        // 4 5 3 2 1

        // stack 1
        // 2
        // 3
        // 4
        // 5
        // pop 5
        // pop 3
        // pop 2
        // pop 1
        int N = popped.length;
        Stack<Integer> stack = new Stack<>();
        int pushIdx = 0;
        int popIdx = 0;

        while (pushIdx <= N) {
            System.out.println("Stack " + stack + " POP " + popIdx + " PUSH " + pushIdx);

            if (!stack.isEmpty() && stack.peek() == popped[popIdx]) {
                stack.pop();
                popIdx++;
            } else {
                if (pushIdx == N) break;
                stack.push(pushed[pushIdx]);
                pushIdx++;
            }
        }
        System.out.println(stack);
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
    }

}
