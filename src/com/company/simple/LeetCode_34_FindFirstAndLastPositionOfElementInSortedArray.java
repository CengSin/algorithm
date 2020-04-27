package com.company.simple;

class LeetCode_34_Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        return new int[]{indexOf(nums, target), lastIndexof(nums, target)};
    }

    private int lastIndexof(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[end] == target) return end;
        if (nums[start] == target) return start;
        return -1;
    }

    private int indexOf(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }

}

public class LeetCode_34_FindFirstAndLastPositionOfElementInSortedArray {
}
