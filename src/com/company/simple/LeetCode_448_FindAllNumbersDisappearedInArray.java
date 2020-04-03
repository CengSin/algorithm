package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/3
 */

class LeetCode_448_Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) res.add(i + 1);
        }
        return res;
    }

}

public class LeetCode_448_FindAllNumbersDisappearedInArray {

    public static void main(String[] args) {
        LeetCode_448_Solution solution = new LeetCode_448_Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
    }

}
