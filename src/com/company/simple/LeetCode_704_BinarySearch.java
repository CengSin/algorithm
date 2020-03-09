package com.company.simple;

/**
 * @description: 二分查找
 * @author: 15262
 * @date: 2020/3/9
 */

class LeetCode_704_Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {

            int mid = i + (j - i) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return -1;
    }
}

public class LeetCode_704_BinarySearch {

    public static void main(String[] args) {
        LeetCode_704_Solution solution = new LeetCode_704_Solution();
        System.out.println(solution.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

}
