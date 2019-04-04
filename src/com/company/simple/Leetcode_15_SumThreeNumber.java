package com.company.simple;

import java.util.Arrays;
import java.util.List;

class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Arrays.stream(nums).forEach(num -> System.out.print(num));
        return null;
    }
}

public class Leetcode_15_SumThreeNumber {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new Solution_15().threeSum(nums);
    }

}
