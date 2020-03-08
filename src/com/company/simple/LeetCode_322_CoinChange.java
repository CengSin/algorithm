package com.company.simple;

import java.util.Arrays;

/**
 * @description: 零钱兑换 动态规划，算法导论第十五章
 * @author: 15262
 * @date: 2020/3/8
 */

class LeetCode_322_Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1]; // dp数组中下标表示金额，值表示最小的硬币数

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i < dp.length; i++) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}

public class LeetCode_322_CoinChange {

    public static void main(String[] args) {
        LeetCode_322_Solution solution = new LeetCode_322_Solution();
        /*System.out.println(solution.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(solution.coinChange(new int[]{2}, 3));*/
        System.out.println(solution.coinChange(new int[]{186, 419, 83, 408}, 6249));
//        System.out.println(solution.coinChange(new int[]{1, 2, 3, 4}, 30));
    }

}
