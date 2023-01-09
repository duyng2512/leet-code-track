package org.dng.code.grooking.array;

import lombok.Builder;


@Builder
public class BestTimeToSellStock {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int slowPointer = 0;
        int currentProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            currentProfit = Math.max(prices[i] - prices[slowPointer], currentProfit);
            if (prices[i] < prices[slowPointer]) {
                slowPointer = i;
            }
        }
        return currentProfit;
    }

}
