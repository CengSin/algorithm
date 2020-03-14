package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 最长升序子序列 dp[i] = max(>=val[i]) + 1 动态规划
 * @author: 15262
 * @date: 2020/3/14
 */
class LeetCode_300_Solution {

    public int lengthOfLISNew(int[] nums) {
        if (nums.length == 0) return 0;

        List<Integer> dp = new ArrayList<>(); // 存储数组中较小的值

        dp.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > dp.get(dp.size() - 1)) {
                dp.add(nums[i]);
            } else {
                // 二分查找dp中按照升序排列的nums[i]应该放置的位子
                int l = 0;
                int r = dp.size() - 1;

                while (l < r) {
                    int mid = (l + r) / 2;
                    if (dp.get(mid) < nums[i]) l = mid + 1;
                    else r = mid;
                }

                dp.set(l, nums[i]);
            }
        }

        return dp.size();
    }

    public int lengthOfLIS(int[] nums) {

        if (nums.length == 0) return 0;

        int maxLen = 1;

        int[] dp = new int[nums.length];

        dp[dp.length - 1] = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j] && dp[i] < (dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
            }
            if (dp[i] == 0) {
                dp[i] = 1;
            }
            if (dp[i] > maxLen) {
                maxLen = dp[i];
            }
        }

        return maxLen;
    }
}

public class LeetCode_300_LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LeetCode_300_Solution solution = new LeetCode_300_Solution();
        System.out.println(solution.lengthOfLISNew(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(solution.lengthOfLISNew(new int[]{10, 9, 2, 5, 3, 4}));
        System.out.println(solution.lengthOfLISNew(new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6}));
    }

}
