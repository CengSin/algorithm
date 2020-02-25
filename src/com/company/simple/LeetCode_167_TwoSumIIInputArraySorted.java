package com.company.simple;

import java.util.Arrays;

class LeetCode_167_Solution {

    public int[] towSum1(int[] numbers, int target) {
        int k = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((k = binarySearch(numbers, i+1, numbers.length - 1, target - numbers[i])) != -1) {
                return new int[]{i + 1, k + 1};
            }
        }
        return new int[]{-1, -1};
    }

        private int binarySearch(int[] numbers, int startIndex, int endIndex, int target) {
            if (startIndex > endIndex) return -1;

            int mid = startIndex + (endIndex - startIndex) / 2;

            if (numbers[mid] > target) return binarySearch(numbers, startIndex, mid - 1, target);
            if (numbers[mid] < target) return binarySearch(numbers, mid + 1, endIndex, target);
            if (numbers[mid] == target) return mid;

            return -1;
        }

    /**
     * 双指针解法，一个指针从头开始，一个指针从尾开始，判断两个指针的和是否等于目标值，如果大于目标值，则尾指针向前移动，如果小于目标值，则头指针向后移动。如果等于目标值，则输出。
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;

        while (i < j && numbers[i] + numbers[j] != target) {
            if (numbers[i] + numbers[j] > target) j--;
            if (numbers[i] + numbers[j] < target) i++;
        }

        return new int[]{i + 1, j + 1};
    }
}

public class LeetCode_167_TwoSumIIInputArraySorted {

    public static void main(String[] args) {
        LeetCode_167_Solution solution = new LeetCode_167_Solution();
        /*for (int i : solution.towSum1(new int[]{2, 7, 11, 15}, 9)) {
            System.out.println(i);
        }*/
        for (int i : solution.towSum1(new int[]{1, 2, 2, 2, 4}, 3)) {
            System.out.println(i);
        }
    }

}
