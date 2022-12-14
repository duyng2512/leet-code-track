package org.dng.code.algo.array;

import org.junit.Assert;
import org.junit.Test;

public class BestTimeToSellStockTest {

    @Test
    public void twoSum() {
        int[][] input = new int[][]{{7,1,5,3,6,4}, {7,6,4,3,1}};
        int[] output = new int[]{5, 0};

        for (int i = 0; i < 2; i++) {
	  System.out.printf("Current [%d] \n", i);
	  Assert.assertEquals(output[i], BestTimeToSellStock.builder().build().maxProfit(input[i]));
        }
    }

}