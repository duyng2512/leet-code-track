package org.dng.code.blind75.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TwoSumTest {

    @Test
    public void twoSum() {
        int[][] inputArray = new int[][]{ {2,7,11,15}, {3,2,4}, {3,3}};
        int[] inputTarget = new int[]{9, 6, 6};
        int[][] expectArray = new int[][]{{0,1}, {1,2}, {0,1}};

        for (int i = 0; i < 3; i++) {
            System.out.printf("Current [%d] \n", i);
            Assert.assertArrayEquals(expectArray[i],
                                    TwoSum.testTwoSum(inputArray[i],
                                                    inputTarget[i]));
        }
    }
}