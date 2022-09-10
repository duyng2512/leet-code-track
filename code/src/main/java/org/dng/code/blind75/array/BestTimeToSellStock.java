package org.dng.code.blind75.array;

import lombok.Builder;


@Builder
public class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int slowPointer = 0;
        int currentProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[slowPointer] > currentProfit){
                currentProfit = prices[i] - prices[slowPointer];
            }
            if (prices[i] < prices[slowPointer]) {
                slowPointer = i;
            }
        }
        return currentProfit;
    }

}
