package org.dng.code.algo.array;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class FindAllSubArr {

public static void main(String[] args) {
	FindAllSubArr.builder().build().allSub(new int[]{1, 2, 3});
}

void allSub(int[] arr) {
	List<Integer> resultArr = new ArrayList<>();
	
	
}
}
