package com.company.simple;

class Solution_35 {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length-1, target);
    }

    /**
     * @date 2018/12/13 21:23
     * @param nums 要查找或插入数字的数组
     * @return 结果
     * @description 二分查找
     * @throws
    */
    private int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (nums[mid] > target) return binarySearch(nums, start, mid-1, target);
        if (nums[mid] < target) return binarySearch(nums, mid+1, end, target);
        return mid;
    }
}

/**
 * Created with IntelliJ IDEA.
 *
 * @Description:
 * @Date: Create in 21:14 2018/12/13
 */
public class LeetCode_35_SearchInsertPosition {

    public static void main(String[] args) {
        Solution_35 solution35 = new Solution_35();
        int index = solution35.searchInsert(new int[]{1,3,5,6}, 2);
        System.out.println(index);
    }

}
