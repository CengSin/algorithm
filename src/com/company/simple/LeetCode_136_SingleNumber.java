package com.company.simple;

import java.util.Arrays;

/**
 * 只出现一次的数字
 */
class LeetCode_136_Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    public int singleNumber2(int[] nums) {
        for (int i = 1; i < nums.length; i ++) {
            nums[0] = nums[i] ^ nums[0];
        }
        return nums[0];
    }
}

public class LeetCode_136_SingleNumber {

    public static void main(String[] args) {
        LeetCode_136_Solution solution = new LeetCode_136_Solution();
        assert solution.singleNumber2(new int[]{4, 1, 2, 1, 2}) == 4;
        assert solution.singleNumber2(new int[]{2, 2, 1}) == 1;
        assert solution.singleNumber2(new int[]{1, 4, 2, 1, 2}) == 4;
        assert solution.singleNumber2(new int[]{1, 4, 5, 1, 5}) == 4;
    }

}
