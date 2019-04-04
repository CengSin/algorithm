package com.company.simple;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 20:01 2018/12/28
 */
public class LeetCode_53_MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{-1, -2, -4, 8,  -7, -2};
        Solution_53 sol = new Solution_53();
        System.out.println(sol.maxSubArray(nums2));
    }

}


class Solution_53 {

    public int maxSubArray(int[] nums) {
        int num = nums[0];
        int sum = 0;
        for (int n : nums) {
            if (sum > 0) sum += n;
            else sum = n;
            num = Math.max(num, sum);
        }
        return num;
    }

}