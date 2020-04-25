package lintcode.chapter3;

class LintCode_458_Solution {

    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int lastPosition(int[] nums, int target) {
        if (null == nums || nums.length == 0) return -1;
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) { // 避免只有两个大小的数组中，mid一直等于0的情况
            int mid = start + (end - start) / 2; // 避免整型溢出
            if (nums[mid] > target) { // 指针往左半边移动
                end = mid;
            } else if (nums[mid] < target) { // 如果是找最后一个出现的位子，则在等于的特殊情况下要往右边移动，如果是找第一次出现的位子，则要往左边一地哦那个
                start = mid;
            } else {
                start = mid; // end = mid;
            }
        }

        if (nums[end] == target) return end;  // 如果是找最后一次出现的位子，则首先判断end下标，否则首先判断start下标
        if (nums[start] == target) return start;
        return -1;
    }

}

public class LintCode_458_LastPositionOfTarget {

    public static void main(String[] args) {

    }

}
