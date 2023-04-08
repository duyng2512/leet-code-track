package org.dng.code.by_tag.depth_first_search;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }


    static public Node cloneGraph(Node node) {

        if (node == null) return null;

        Node head = new Node();
        Node cur = head;

        Stack<Node> stack = new Stack<>();
        boolean[] seen = new boolean[101];
        Map<Integer, Node> map = new HashMap<>();

        stack.push(node);

        // Doing DFS transversal
        // Create first the ref from val to Node and Node
        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (!seen[pop.val]) {
                cur = new Node(pop.val);

                // Init head
                if (head.val == 0) head = cur;
                map.put(pop.val, cur);
                seen[pop.val] = true;

                for (Node neighbor : pop.neighbors) {
                    if (!seen[neighbor.val]) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        stack = new Stack<>();
        seen = new boolean[100];
        stack.push(node);

        while (!stack.isEmpty()) {
            Node pop = stack.pop();
            if (!seen[pop.val]) {

                seen[pop.val] = true;
                Node newNode = map.get(pop.val);
                for (Node neighbor : pop.neighbors) {
                    Node newNeighbor = map.get(neighbor.val);
                    newNode.neighbors.add(newNeighbor);
                    if (!seen[neighbor.val]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);

        a.neighbors.add(b);
        a.neighbors.add(d);

        b.neighbors.add(a);
        b.neighbors.add(c);

        c.neighbors.add(b);
        c.neighbors.add(d);

        d.neighbors.add(a);
        d.neighbors.add(c);

        Node node = cloneGraph(a);
        System.out.println(node);
    }

}

















