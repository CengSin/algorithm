package com.company.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 存在重复元素
 * @author: 15262
 * @date: 2020/3/18
 */
class LeetCode_217_Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        return sets.size() < nums.length;
        /*return Arrays.stream(nums).distinct().count() < nums.length;*/
    }
}

public class LeetCode_217_ContainsDuplicate {
}
