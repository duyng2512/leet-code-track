package org.dng.code.algo.array;

import org.junit.Assert;
import org.junit.Test;

public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        Assert.assertEquals(6, MaximumSubarray.builder().build().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}