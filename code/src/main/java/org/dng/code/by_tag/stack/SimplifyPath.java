package org.dng.code.by_tag.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SimplifyPath {

    static public String simplifyPath(String path) {
        path = path.replace("//", "/");

        if (path.startsWith("/")) path = path.substring(1);
        if (path.endsWith("/")) path = path.substring(0, path.length() - 1);

        String[] dirs = path.split("/", -1);
        System.out.println(Arrays.toString(dirs));
        Deque<String> deque = new ArrayDeque<>();
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!deque.isEmpty()) deque.removeLast();
            } else {
                if (!dir.equals(".") && !dir.equals("")) deque.add(dir);
            }
        }

        StringBuilder res = new StringBuilder();
        System.out.println(deque);
        while (!deque.isEmpty()) {
            String pop = deque.pollFirst();
            if (pop.length() >= 1) {
                res.append("/");
                res.append(pop);
            }
        }
        if (res.length() == 0) return "/";
        return res.toString();
    }


    public static void main(String[] args) {
        System.out.println(simplifyPath("/a/./b/../../c/")); // "/c"
        System.out.println(simplifyPath("/a//b////c/d//././/..")); // "/a/b/c"

    }
}
