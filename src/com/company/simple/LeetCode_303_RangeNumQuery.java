package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/29
 */

class LeetCode_303_NumArray {

    private int[] nums;

    public LeetCode_303_NumArray(int[] nums) {
        if (nums != null) {
            this.nums = new int[nums.length + 1];

            this.nums[0] = 0;
            for (int i = 1; i <= nums.length; i++) {
                this.nums[i] = nums[i - 1] + this.nums[i - 1];
            }
        }
    }

    public int sumRange(int i, int j) {
        return this.nums[j + 1] - this.nums[i];
    }
}


public class LeetCode_303_RangeNumQuery {
}
