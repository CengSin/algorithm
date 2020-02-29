package com.company.simple;

/**
 * @description: 使用最小花费爬楼梯，求最小花费只能倒序来，如果正序的话，会因为顺序的原因导致结果不正确
 * @author: 15262
 * @date: 2020/2/29
 */

class LeetCode_746_Solution {

    public int minCostClimbingStairs(int[] cost) {

        int pre, cur;

        pre = cost[0];
        cur = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int tmp = cur;
            cur = Math.min(pre, cur) + cost[i];
            pre = tmp;
        }

        return Math.min(pre, cur);

    }

}

public class LeetCode_746_MinCostClimbingStairs {

    public static void main(String[] args) {
        LeetCode_746_Solution solution = new LeetCode_746_Solution();
        System.out.println(solution.minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(solution.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(solution.minCostClimbingStairs(new int[]{0, 0, 1, 1}));
        System.out.println(solution.minCostClimbingStairs(new int[]{0, 1, 1, 0}));
        System.out.println(solution.minCostClimbingStairs(new int[]{0, 1, 2, 2}));
        System.out.println(solution.minCostClimbingStairs(new int[]{0, 2, 2, 1}));
    }

}
