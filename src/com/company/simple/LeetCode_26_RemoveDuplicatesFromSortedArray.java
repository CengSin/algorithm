package com.company.simple;

class LeetCode_26_Solution {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int k = i;
            while (k < len && nums[k] == nums[i]) {
                k++;
            }
            int move = k - i - 1;
            int j = i + 1;
            while (j < len - move) {
                nums[j] = nums[j + move];
                j++;
            }
            len -= move;
        }
        return len;
    }

}

public class LeetCode_26_RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        LeetCode_26_Solution solution = new LeetCode_26_Solution();
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
        int len = solution.removeDuplicates(nums);

        // 在函数里修改输入数组对于调用者是可见的。
        // 根据你的函数返回的长度, 它会打印出数组中该长度范围内的所有元素。
        for (int i = 0; i < len; i++) {
            System.out.print(nums[i] + " ");
        }
    }

}
