package com.company.simple;

import java.util.Arrays;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/5
 */

class LeetCode_17_10_Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length / 2;
        for (int i = 0; i <= len; i++) {
            if (nums[i] == nums[(i + len) % nums.length]) {
                return nums[i];
            }
        }
        return -1;
    }
}

public class LeetCode_17_10_FindMajorityElementLCCI {

    public static void main(String[] args) {
        LeetCode_17_10_Solution solution = new LeetCode_17_10_Solution();
        System.out.println(solution.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(solution.majorityElement(new int[]{2, 3}));
        System.out.println(solution.majorityElement(new int[]{3, 2, 3}));
    }

}
