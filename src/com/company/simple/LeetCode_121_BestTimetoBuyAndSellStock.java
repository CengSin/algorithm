package com.company.simple;

class LeetCode_121_Solution {
    public int maxProfit(int[] prices) {
        // 动态规划 前i天的最大收益 = max(前i-1天的最大收益，第i天的价格 - 前i天的最小价格)
        if (prices.length <= 1) {
            return 0;
        }
        // 最大利润 = 当天的价格 - 前几天的最低价
        // 定义两个变量
        int minPrice = prices[0]; // 最小价格 ， 在第一天的时候，最小价格=当天价
        int maxGain = 0; // 最大利润 最大利润 = Math.max(第i天价格 - 前i天内的最低价， 前i - 1天的最大收益)

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            maxGain = Math.max(prices[i] - minPrice, maxGain);
        }

        return maxGain;
    }
}

public class LeetCode_121_BestTimetoBuyAndSellStock {
    public static void main(String[] args) {
        LeetCode_121_Solution solution = new LeetCode_121_Solution();
        System.out.println(solution.maxProfit(new int[]{7,6,4,3,1}));
    }
}
