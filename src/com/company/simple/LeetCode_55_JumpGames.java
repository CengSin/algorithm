package com.company.simple;

/**
 * 跳跃游戏
 */

class LeetCode_55_Solution {

    /**
     * 贪心算法，判断每个位子能够到达的最远距离，同时也要判断当前位子是不是之前最大距离的范围内 2ms
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        if (nums.length < 2) return true;
        int maxLen = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= maxLen) {
                maxLen = Math.max(i + nums[i], maxLen);
            }
        }
        return maxLen >= nums.length - 1;
    }

    /**
     * 从数组倒数第二个位子判断能不能到达最后一个数组，也就是distance >= 1
     * 否则从第三个位子判断能否到达最后一个数字， distance >= 2
     *
     * @param nums
     * @return
     */
    public boolean canJump1ms(int[] nums) {
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < distance) {
                distance++;
            } else {
                distance = 1;
            }
        }
        return distance == 1;
    }

    /**
     * 时间复杂度O(n^2)会超时
     *
     * @param nums
     * @return
     */
    public boolean canJumpTimeout(int[] nums) {
        if (nums.length == 1) return true;
        return jump(nums, 0);
    }

    private boolean jump(int[] nums, int start) {
        if (nums[start] > 0 || start == nums.length - 1) {

            if (start == nums.length - 1) {
                return true;
            }

            int index = 1;
            for (int i = index; i <= nums[start] && start + i < nums.length; i++) {
                if (jump(nums, start + i)) {
                    return true;
                }
            }

        }
        return false;
    }

}

public class LeetCode_55_JumpGames {

    public static void main(String[] args) {
        LeetCode_55_Solution solution = new LeetCode_55_Solution();
        System.out.println(solution.canJump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(solution.canJump(new int[]{2, 0}));
        System.out.println(solution.canJump(new int[]{2, 0, 0}));
        System.out.println(solution.canJump(new int[]{3, 2, 1, 0}));
    }

}
