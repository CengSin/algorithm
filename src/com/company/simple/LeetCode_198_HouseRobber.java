package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/28
 */

class LeetCode_198_Solution {
    public int rob(int[] nums) {
        int pre = 0;
        int cur = 0;

        for (int i = 0; i < nums.length; i++) {
            int tmp = cur;
            cur = Math.max(pre + nums[i], cur);
            pre = tmp;
        }

        return cur;
    }

}

public class LeetCode_198_HouseRobber {

    public static void main(String[] args) {
        LeetCode_198_Solution solution = new LeetCode_198_Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
        System.out.println(solution.rob(new int[]{2, 7, 9, 3, 1}));
        System.out.println(solution.rob(new int[]{1, 1}));
        System.out.println(solution.rob(new int[]{2, 1}));
        System.out.println(solution.rob(new int[]{2, 1, 1, 2}));
    }

}

