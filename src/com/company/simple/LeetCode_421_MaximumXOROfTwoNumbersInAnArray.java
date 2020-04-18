package com.company.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class LeetCode_421_Solution {

    // O(n)
    public int findMaximumXORByHashPrefix(int[] nums) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        // 求最大值的位数
        int length = Integer.toBinaryString(maxNum).length();
        // 计算每一位上的最大值
        // 11*** 111** 1111* 11111
        int maxXor = 0,  curXor = 0;
        Set<Integer> hashPrefix = new HashSet<>();
        for (int i = length - 1; i >= 0; i--) {
            maxXor <<= 1;
            curXor = maxXor | 1; // 1**** 11*** 111** 1111* 11111
            hashPrefix.clear();
            for (int num : nums) hashPrefix.add(num >> i);

            for (Integer prefix : hashPrefix) {
                if (hashPrefix.contains(prefix ^ curXor)) {
                    maxXor = curXor;
                    break;
                }
            }
        }

        return maxXor;
    }

    // O(n^2) 192ms
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                max = Math.max(nums[i] ^ nums[j], max);
            }
        }
        return max;
    }

}

public class LeetCode_421_MaximumXOROfTwoNumbersInAnArray {

    public static void main(String[] args) {
        LeetCode_421_Solution solution = new LeetCode_421_Solution();
        System.out.println(solution.findMaximumXORByHashPrefix(new int[]{3, 10, 5, 25, 2, 8}));
    }

}
