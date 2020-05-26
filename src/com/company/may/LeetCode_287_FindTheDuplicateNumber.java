package com.company.may;

import java.util.Arrays;

class LeetCode_287_Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; ++i) {
            if (binarySearch(nums, i + 1, nums.length - 1, nums[i]) > i) {
                return nums[i];
            }
        }
        return -1;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int left = start;
        int right = end;

        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}

public class LeetCode_287_FindTheDuplicateNumber {
}
