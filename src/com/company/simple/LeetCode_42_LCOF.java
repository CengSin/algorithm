package com.company.simple;

/**
 * @description: 连续子数组的最大和
 * @author: 15262
 * @date: 2020/3/8
 */

class LeetCode_42_LCOF_Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            dp[0] = Math.max(dp[i], dp[0]);
        }
        return dp[0];
    }
}

public class LeetCode_42_LCOF {

    public static void main(String[] args) {
        LeetCode_42_LCOF_Solution solution = new LeetCode_42_LCOF_Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
