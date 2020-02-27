package com.company.simple;

/**
 * @description: 旋转数组 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * @author: 15262
 * @date: 2020/2/27
 */

class LeetCode_189_Solution {

    public void rotate(int[] nums, int k) {
        // 优化，可能输入的k特别大，所以循环数组同等长度 == 不循环，将k%数组长度优化时间
        k %= nums.length;
        while (k-- > 0) {
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = tmp;
        }
    }

    public void reversal(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reversal(nums, 0, n - 1);
        reversal(nums, 0, k - 1);
        reversal(nums, k, n - 1);

        soutNums(nums);
    }

    private void soutNums(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public void reversal(int[] nums, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            int tmp = nums[startIndex];
            nums[startIndex++] = nums[endIndex];
            nums[endIndex--] = tmp;
        }
    }
}

public class LeetCode_189_RotateArray {

    public static void main(String[] args) {
        LeetCode_189_Solution solution = new LeetCode_189_Solution();
        solution.reversal(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        solution.reversal(new int[]{-1, -100, 3, 99}, 2);
    }

}
