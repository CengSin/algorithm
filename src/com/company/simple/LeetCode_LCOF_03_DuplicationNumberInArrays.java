package com.company.simple;

import java.util.HashSet;

class LeetCode_LCOF_03_Solution {
    public int findRepeatNumber(int[] nums) {
        // for(int i = 1; i < nums.length; i++) {
        //     for(int j = 0; j < i; j++) {
        //         if (nums[j] > nums[i]) {
        //             nums[j] += nums[i];
        //             nums[i] = nums[j] - nums[i];
        //             nums[j] -= nums[i];
        //         }
        //     }
        // }
        // Arrays.sort(nums);

        // for(int i = 0; i < nums.length; i++) {
        //     if (i > 0 && nums[i] == nums[i - 1]) return nums[i];
        // }
        // return 0;

        // O(n)时间复杂度 O(n)空间复杂度
        HashSet<Integer> sets = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if (sets.contains(nums[i])) return nums[i];
            sets.add(nums[i]);
        }
        return 0;
    }
}

public class LeetCode_LCOF_03_DuplicationNumberInArrays {
}
