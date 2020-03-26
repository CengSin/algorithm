package com.company.simple;

import com.company.simple.datastruct.ListNode;

import java.util.*;

/**
 * @description: 数组的度
 * @author: 15262
 * @date: 2020/3/26
 */

class LeetCode_697_Solution {

    public int findShortestSubArray(int[] nums) {
        // 距离最近且出现频率最高
        Map<Integer, List<Integer>> hash = new HashMap<>();
        int maxCnt = 0;
        // 先求出数组的度
        for (int i = 0; i < nums.length; i++) {
            if (!hash.containsKey(nums[i])) {
                hash.put(nums[i], new ArrayList<>());
            }
            List<Integer> lists = hash.get(nums[i]);
            lists.add(i);
            if (lists.size() > maxCnt) {
                maxCnt = lists.size();
            }
        }
        int minLen = Integer.MAX_VALUE;
        for (Integer key : hash.keySet()) {
            List<Integer> lists = hash.get(key);
            if (lists.size() == maxCnt) {
                int sum = 0;
                for (int i = lists.size() - 1; i > 0; i--) {
                    sum += (lists.get(i) - lists.get(i-1));
                }
                if (sum < minLen) {
                    minLen = sum;
                }
            }
        }
        return minLen + 1;
    }

}

public class LeetCode_697_DegreeOfArray {

    public static void main(String[] args) {
        LeetCode_697_Solution solution = new LeetCode_697_Solution();
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(solution.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(solution.findShortestSubArray(new int[]{1, 1, 2, 2, 2, 1}));
    }

}
