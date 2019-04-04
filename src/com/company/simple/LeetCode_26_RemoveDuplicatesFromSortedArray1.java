package com.company.simple;

import java.util.Arrays;

class Solution_26 {
    // todo 想法1 找素数，取余作为index
    // todo 想法2 数组位移
    public int removeDuplicates(int[] nums) {
        int max = nums[0];

        for (int i = 0;  i<nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            nums[nums[i] % max] = nums[i];
        }

        System.out.println(Arrays.toString(nums));
        return 0;
    }

    private void move(int[] nums, int start) {
        for (;start < nums.length; start ++) {
            nums[start-1] = nums[start];
        }
    }
}

public class LeetCode_26_RemoveDuplicatesFromSortedArray1 {

    public void test1() {
        System.out.println("start-test1");
        test2();
        System.out.println("end-test1");
    }

    private void test2() {
        System.out.println("start-test2");
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        new Solution_26().removeDuplicates(new int[]{1, 1, 1, 1, 2, 2, 3, 3, 3});
        new LeetCode_26_RemoveDuplicatesFromSortedArray1().test1();
    }

}
