package com.company.simple;

import java.util.Arrays;

/**
 * @description: 数组排序
 * @author: 15262
 * @date: 2020/3/31
 */
class LeetCode_912_Solution {
    public int[] sortArray(int[] nums) {
        Arrays.sort(nums);
        return nums;
    }
}

public class LeetCode_912_SortArray {

    public static void main(String[] args) {
        LeetCode_912_Solution solution = new LeetCode_912_Solution();
        System.out.println(Arrays.toString(solution.sortArray(new int[]{7, 6, 5, 4, 3, 2, 1})));
    }

}
