package com.company.simple;

import java.util.Arrays;

class Solution_27 {

    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        for (int i = 0 ; i < length; ) {
            if (nums[i] == val) {
                move(nums, i+1);
                length--;
            } else {
                i++;
            }
        }
        return length;
    }

    private void move(int[] nums, int start) {
        for (int i = start; i < nums.length; i++) {
            nums[i-1] = nums[i];
        }
    }

}

public class LeetCode_27_RemoveElement {

    public static void main(String[] args) {
//        int[] nums = {0,1,2,2,3,0,4,2};
        int[] nums = {1};
        Solution_27 solution_27 = new Solution_27();
        for (int i = 0 ; i < solution_27.removeElement(nums, 1); i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

}
