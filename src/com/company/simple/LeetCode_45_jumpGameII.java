package com.company.simple;

/**
 * 跳出数组的最短跳跃次数
 */

class LeetCode_45_Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int maxStep = nums[0];
        int step = 1;
        int index = 0;
        while (maxStep < nums.length - 1) {
            int curStep = nums[index];
            for (int i = index + 1; i <= maxStep; i++) {
                if (i + nums[i] > curStep) {
                    curStep = i + nums[i];
                    index = i;
                }
            }
            maxStep = index + nums[index];
            step ++;
        }
        return step;
    }
}

public class LeetCode_45_jumpGameII {
}
