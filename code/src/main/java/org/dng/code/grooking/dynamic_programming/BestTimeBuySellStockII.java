package org.dng.code.grooking.dynamic_programming;

/**
 * @author duyntc 01/2023
 */
public class BestTimeBuySellStockII {

static public int maxProfit(int[] prices) {
	if (prices.length == 1) {
		return 0;
	}
	int current = 0;
	int prev = prices[0];
	int total = 0;
	for (int i = 1; i < prices.length; i++) {
		current = prices[i];
		if (current > prev) {
			total += current - prev;
		}
		prev = current;
	}
	return total;
}

public static void main(String[] args) {
	System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4})); // 7
}

}
