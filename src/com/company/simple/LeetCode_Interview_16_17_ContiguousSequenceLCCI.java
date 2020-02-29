package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/28
 */

class LeetCode_Interview_16_17_Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxSum = Math.max(maxSum, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}

public class LeetCode_Interview_16_17_ContiguousSequenceLCCI {

    public static void main(String[] args) {
        LeetCode_Interview_16_17_Solution solution = new LeetCode_Interview_16_17_Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray(new int[]{-2, 1}));
    }

}
