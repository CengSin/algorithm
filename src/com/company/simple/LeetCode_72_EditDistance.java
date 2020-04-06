package com.company.simple;

/**
 * @description: 编辑距离
 * @author: 15262
 * @date: 2020/4/6
 */

class LeetCode_72_Solution {
    public int minDistance(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();

        int[][] dp = new int[length1 + 1][length2 + 1];

        for (int i = 0; i <= length1; i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= length2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
            }
        }

        return dp[length1][length2];
    }
}

public class LeetCode_72_EditDistance {

    public static void main(String[] args) {
        LeetCode_72_Solution solution = new LeetCode_72_Solution();
        System.out.println(solution.minDistance("horse", "ros"));
    }

}
