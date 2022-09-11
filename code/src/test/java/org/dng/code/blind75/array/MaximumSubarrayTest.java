package org.dng.code.blind75.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaximumSubarrayTest {

    @Test
    public void maxSubArray() {
        Assert.assertEquals(6, MaximumSubarray.builder().build().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}