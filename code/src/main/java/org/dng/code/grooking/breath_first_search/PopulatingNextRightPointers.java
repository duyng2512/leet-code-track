package org.dng.code.grooking.breath_first_search;

import lombok.Builder;
import org.dng.code.utils.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@Builder
public class PopulatingNextRightPointers {
     
     /*
     
          You are given a perfect binary tree where all leaves are on the same level,
          and every parent has two children. The binary tree has the following definition:

          struct Node {
            int val;
            Node *left;
            Node *right;
            Node *next;
          }
          Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
          
          Initially, all next pointers are set to NULL.
          
          Input: root = [1,2,3,4,5,6,7]
          Output: [1,#,2,3,#,4,5,6,7,#]
          Explanation: Given the above perfect binary tree (Figure A), your function should populate each next
          pointer to point to its next right node, just like in Figure B. The serialized output is in level
          order as connected by the next pointers, with '#' signifying the end of each level.
      */
     public Node connect(Node root) {
          if (root ==  null) return null;
          
          List<List<Node>> result = new ArrayList<>();
          Queue<Node> queue = new ArrayDeque<>();
          int level = 0;
          queue.add(root);
          
          
          while (!queue.isEmpty()) {
               if (level == result.size()) {
                    result.add(new ArrayList<>()); // Start a new level
               }
               
               int levelLen = queue.size();
               for (int i = 0; i < levelLen; i++) {
                    Node temp = queue.remove();
                    result.get(level).add(temp);
                    if (temp.left != null) queue.add(temp.left);
                    if (temp.right != null) queue.add(temp.right);
               }
               level++;
          }
          result.forEach(levelNodes -> {
               for (int i = 0; i < levelNodes.size(); i++) {
                    if ( i != levelNodes.size()-1) levelNodes.get(i).next = levelNodes.get(i+1);
                    else levelNodes.get(i).next = null;
               }
          });
          return root;
     }
     
     public static void main(String[] args) {
          Node root = new Node(1);
          root.left = new Node(2);
          root.right = new Node(3);
          root.left.left = new Node(4);
          root.left.right = new Node(5);
          root.right.left = new Node(6);
          root.right.right = new Node(7);
          
          Node node = PopulatingNextRightPointers.builder().build().connect(root);
          
     }
     
}
