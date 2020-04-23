package com.company.simple;

/**
 * 硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 */

class LeetCode_LCOF_08_11_Solution {

    public LeetCode_LCOF_08_11_Solution() {
    }

    /**
     * 计算n面额的硬币使用coins=[25, 10, 5, 1]的硬币来表示一共有多少种表示方法
     *
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        // 设置递归终点
        dp[0] = 1;

        // 两层循环罗列所有的情况
        for (int coin : coins) {
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        return dp[n];
    }

}

public class LeetCode_LOCF_08_11_Coins {
}
