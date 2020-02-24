package com.company.simple;

class LeetCode_122_Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i+1]) {
                maxProfit += prices[i + 1] - prices[i];
            }
        }
        return maxProfit;
    }
}

public class LeetCode_122_BestTime2BuyAndSellStockII {

    public static void main(String[] args) {
        LeetCode_122_Solution solution = new LeetCode_122_Solution();
        System.out.println("max profit = " + solution.maxProfit(new int[]{7,1,5,3,6,4}));
    }

}
