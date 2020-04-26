package lintcode.chapter3;

/**
 * 给 n 个整数的山脉数组，即先增后减的序列，找到山顶（最大值）
 * <p>
 * 先增后减，这是整个数组的特性，找到山顶，根绝先增后减的特性，不停的缩小数组符合特性的范围，就可以找到山顶了
 */
class LintCode_585_Solution {

    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[mid + 1]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return Math.max(nums[start], nums[end]);
    }

}

public class LintCode_585_MaximumNumberInMountainSequence {

    public static void main(String[] args) {

    }

}
