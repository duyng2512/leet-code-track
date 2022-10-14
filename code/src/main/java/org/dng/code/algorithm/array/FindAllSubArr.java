package org.dng.code.algorithm.array;

import lombok.Builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Builder
public class FindAllSubArr {
     
     void allSub(int[] arr) {
          List<Integer> resultArr = new ArrayList<>();
          
          
     }
     
     public static void main(String[] args) {
          FindAllSubArr.builder().build().allSub(new int[] {1, 2, 3} );
     }
}
