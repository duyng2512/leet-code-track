package org.dng.code.interview;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EmploymentHero {

    static class Task1 {

        static public boolean solution(String x, String y) {
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < y.length(); i++) {
                set.add(y.charAt(i));
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < x.length(); i++) {
                if (set.contains(x.charAt(i))) {
                    sb.append(x.charAt(i));
                }
            }
            return sb.toString().contains(y);
        }

        public static void main(String[] args) {
            System.out.println(solution("ABCD", "D"));
            System.out.println(solution("ABCD", "CA"));
            System.out.println(solution("ABCAD", "BA"));
        }
    }

    static class Task2 {

        static public int solution(String[] connections, String name1, String name2) {
            Map<String, Node> map = new HashMap<>();

            for (String connection : connections) {
                String p1 = connection.substring(0, connection.indexOf(":"));
                String p2 = connection.substring(connection.indexOf(":") + 1);

                Node node2, node1;

                if (!map.containsKey(p2)) {
                    node2 = new Node(p2);
                    map.put(p2, node2);
                } else {
                    node2 = map.get(p2);
                }

                if (!map.containsKey(p1)) {
                    node1 = new Node(p1, node2);
                    map.put(p1, node1);
                } else {
                    node1 = map.get(p1);
                    node1.next = node2;
                }
            }

            Node cur = map.get(name1);
            int count = 0;
            if (cur == null) return -1;
            while (cur != null) {
                if (cur.data.equals(name2)) {
                    return count - 1;
                }
                cur = cur.next;
                count++;
            }
            return -1;
        }

        public static void main(String[] args) {
            String[] string = new String[]{"fred:joe", "joe:mary", "kate:sean", "sean:sally"};
            int res = solution(string, "fred", "sally");
            System.out.println(res);

            string = new String[]{"fred:joe", "joe:mary", "mary:fred", "mary:bill"};
            res = solution(string, "fred", "bill");
            System.out.println(res);

        }

        static class Node {
            String data;
            Node next = null;

            public Node(String data, Node next) {
                this.data = data;
                this.next = next;
            }

            public Node(String data) {
                this.data = data;
            }
        }
    }

}
