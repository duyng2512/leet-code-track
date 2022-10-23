package org.dng.code.grooking.pattern_merge;

import lombok.Builder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

@Builder
public class MinimumMeetingRooms {
     
     /*
	Solution Review: Problem Challenge 1 - Minimum Meeting Rooms (hard)
	Given a list of intervals representing the start and end time of ‘N’ meetings,
	find the minimum number of rooms required to hold all the meetings.
	
	Example 1:
	Meetings: [[1,4], [2,3], [2,5], [7,9]]
	Output: 2
	
	Explanation: Since [1,4] and [2,5] overlap, we need two rooms to hold these two meetings. [7,9] can
	occur in any of the two rooms later.
	
	Example 2:
	Meetings: [[6,7], [2,4], [8,12]]
	
	Output: 1
	Explanation: None of the meetings overlap, therefore we only need one room to hold all meetings.
	
	Example 3:
	Meetings: [[1,4], [2,3], [3,6]]
	Output:2
	Explanation: Since [1,4] overlaps with the other two meetings [2,3] and [3,6], we need two rooms to
	hold all the meetings.
	
	Example 4:
	Meetings: [[4,5], [2,3], [2,4], [3,5]]
	Output: 2
	Explanation: We will need one room for [2,3] and [3,5], and another room for [2,4] and [4,5].
	
      */
     
     public int minMeetingRooms(int[][] intervals) {
          if (intervals.length == 0) return 0;
          // Room order and its end time
          Map<Integer, Integer> rooms = new HashMap<>();
          Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
          rooms.put(0, intervals[0][1]);
     
          for (int i = 1; i < intervals.length; i++) {
               // Check if needed new room
               boolean needNewRoom = true;
               for (Map.Entry<Integer, Integer> room : rooms.entrySet()) {
                    if (room.getValue() <= intervals[i][0]) {
                         // There is available room
                         room.setValue(intervals[i][1]);
                         // Update new end
                         needNewRoom = false;
                         break;
                    }
               }
               if (needNewRoom) rooms.put(i, intervals[i][1]);
          }
          return rooms.size();
     }
     
     public static void main(String[] args) {
          System.out.println(MinimumMeetingRooms.builder().build().minMeetingRooms(new int[][] {{1,4}, {2,3}, {2,5}, {7,9}}));
          // [[6,7], [2,4], [8,12]]

          System.out.println(MinimumMeetingRooms.builder().build().minMeetingRooms(new int[][] {{6,7}, {2,4}, {8,12}}));
          // [[1,4], [2,3], [3,6]]

          System.out.println(MinimumMeetingRooms.builder().build().minMeetingRooms(new int[][] {{1,4}, {2,3}, {3,6}}));

          // [[4,5], [2,3], [2,4], [3,5]]
          System.out.println(MinimumMeetingRooms.builder().build().minMeetingRooms(new int[][] {{4,5}, {2,3}, {2,4}, {3,5}}));
          
          // {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}}
          // {300,5870} {518,2918} {848,3846} {1293,2986} {4284,5907} {4466,4781}}
          System.out.println(MinimumMeetingRooms.builder().build().minMeetingRooms(new int[][]  {{1293,2986},{848,3846},{4284,5907},{4466,4781},{518,2918},{300,5870}} ));
     }
     
}
