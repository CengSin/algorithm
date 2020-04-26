package lintcode.chapter3;

/**
 * 旋转数组的最小值
 *
 * 一部分递增
 * 另一部分也递增
 * 两边端点往中间缩小与nums中最后的一个数字进行对比，按照递增的特性
 */

class LintCode_159_Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
        int target = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.min(nums[start], nums[end]);
    }
}

public class LintCode_159_FindMinimumInRotatedSortedArray {
}
