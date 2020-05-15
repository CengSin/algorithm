package com.company.may;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中和为k的连续子数组
 */
class Solution {
    public int subarraySum(int[] nums, int k) {
        // 暴力循环
        // return enums(nums, k);
        // 优化 前缀和
        /**
         * 新建一个pre数组用来存储0~i的前缀和 pre[i] = pre[i - 1] + nums[i]
         * ，假设j……i之间的数字和为k，
         * 那么pre[j - 1] = pre[i] - k
         *
         */
        return preSum(nums, k);
    }

    private int preSum(int[] nums, int k) {
        int count = 0;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k))
                count += map.get(pre - k);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    private int enums(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum == k) {
                    count ++;
                }
            }
        }
        return count;
    }
}

public class LeetCode_560_SubarraySumEqualsK {
}
