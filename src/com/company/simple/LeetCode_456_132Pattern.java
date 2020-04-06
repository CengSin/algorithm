package com.company.simple;

import java.util.Stack;

/**
 * @description: 132模式
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。
 * 设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 不要求子序列连续
 * @author: 15262
 * @date: 2020/4/6
 */

class LeetCode_456_Solution {

    // 单调栈维护次大值
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3) return false;
        // 首先遍历元素中最小的值
        int[] mins = new int[nums.length];
        mins[0] = nums[0];
        for (int i = 1; i < mins.length; i++) {
            mins[i] = Math.min(nums[i], mins[i - 1]);
        }

        // 维护单调递减的栈
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > mins[i]) {
                while (!stack.isEmpty() && stack.peek() <= mins[i]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }

}

public class LeetCode_456_132Pattern {

    public static void main(String[] args) {
        LeetCode_456_Solution solution = new LeetCode_456_Solution();
        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(solution.find132pattern(new int[]{-1, 3, 2, 0}));
    }

}
