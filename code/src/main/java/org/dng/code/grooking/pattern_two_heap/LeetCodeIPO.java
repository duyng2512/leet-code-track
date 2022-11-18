package org.dng.code.grooking.pattern_two_heap;

import lombok.Builder;

import java.util.*;

import java.util.stream.Collectors;

@Builder
public class LeetCodeIPO {
     
     /*
          https://leetcode.com/problems/ipo/
      */
     
     static class Project {
          int profit;
          int capital;
     
          public Project(int profit, int capital) {
               this.profit = profit;
               this.capital = capital;
          }
     
          public int getProfit() {
               return profit;
          }
     
          public int getCapital() {
               return capital;
          }
     
          @Override
          public String toString() {
               return "Project{" +
                    "profit=" + profit +
                    ", capital=" + capital +
                    '}';
          }
     }
     
     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
	int len = profits.length;
     
          // List of project yet implement
          Comparator<Project> comparatorProfit = (o1, o2) -> o2.getProfit() - o1.getProfit();
          Comparator<Project> comparatorCap = (o1, o2) -> o1.getCapital() - o2.getCapital();
          PriorityQueue<Project> profit = new PriorityQueue<>(comparatorProfit);
          PriorityQueue<Project> cap = new PriorityQueue<>(comparatorCap);
          
          for (int i = 0; i < len; i++) {
               cap.add(new Project(profits[i], capital[i]));
          }
     
          for (int i = 0; i < k; i++) {
               while (!cap.isEmpty() && cap.peek().getCapital() <= w){
                    profit.add(cap.poll());
               }
               if (profit.isEmpty()) break;
               w += profit.poll().profit;
          }
          
          return w;
     }
     
     public static void main(String[] args) {
          int result = LeetCodeIPO.builder()
                              .build()
                              .findMaximizedCapital(2, 0, new int[]{1,2,3,5}, new int[]{0,1,2,0});
          System.out.println(result);
     
          /*
          
               Project project1 = new Project(2, 1);
               Project project2 = new Project(3, 1);
               Comparator<Project> comparator = (o1, o2) -> o2.getProfit() - o1.getProfit();
               PriorityQueue<Project> priorityQueue = new PriorityQueue<>(comparator);
               priorityQueue.addAll(Arrays.asList(project2, project1));
               Project temp = priorityQueue.poll();
               assert temp != null;
               System.out.println(temp.capital +" "+ temp.profit);
          
           */
     }
     
}
