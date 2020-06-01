package lintcode.chapter5;

import java.util.Arrays;

class LintCode_521_Solution {
    /**
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[res] != nums[i]) {
                nums[res ++] = nums[i];
            }
        }
        return res + 1;
    }
}

public class LintCode_521_RemoveDuplicationInArray {
}
