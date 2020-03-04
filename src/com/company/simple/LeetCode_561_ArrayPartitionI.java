package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/4
 */

class LeetCode_561_Solution {
    public int arrayPairSum(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i += 2) {
            sum += nums[i];
        }
        return sum;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int q = partition(nums, low, high);
            quickSort(nums, low, q - 1);
            quickSort(nums, q + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int x = nums[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++) {
            if (nums[j] <= x) {
                i = i + 1;
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        nums[high] = nums[i + 1];
        nums[i + 1] = x;
        return i + 1;
    }

    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            int tmp = nums[i];

            while (j >= 0 && nums[j] > tmp) {
                nums[j + 1] = nums[j];
                j = j - 1;
            }

            nums[j + 1] = tmp;
        }
    }
}

public class LeetCode_561_ArrayPartitionI {

    public static void main(String[] args) {
        LeetCode_561_Solution solution = new LeetCode_561_Solution();
         System.out.println(solution.arrayPairSum(new int[]{1, 4, 3, 2}));
        System.out.println(solution.arrayPairSum(new int[]{7, 3, 1, 0, 0, 6}));
    }

}
