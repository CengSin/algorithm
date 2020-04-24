package com.company.simple;

/**
 * 数组中的逆序对
 */
class LeetCode_51_Solution {

    public int reversePairsTimeOut(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) sum++;
            }
        }
        return sum;
    }

    public int reversePairs(int[] nums) {

        if (nums.length == 0) return 0;

        return mergeSort(nums, 0, nums.length - 1);

    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;

        int mid = start + ((end - start) / 2); // 防止整型溢出

        return mergeSort(nums, start, mid) // 排序左半边
                + mergeSort(nums, mid + 1, end)  // 排序右半边
                + merge(nums, start, mid, end); // 排序整个数组
    }

    private int merge(int[] nums, int start, int mid, int end) {
        int a1Start = start, a1End = mid, a2Start = mid + 1, a2End = end;
        int ans = 0, i = 0;

        int[] mergeArr = new int[end - start + 1];
        while (a1Start <= a1End && a2Start <= a2End) {
            if (nums[a1Start] > nums[a2Start]) {
                ans += a2End - a2Start + 1; // 如果前面的值大于后面的值,且数组是有序的
                mergeArr[i++] = nums[a1Start++];
            } else {
                mergeArr[i++] = nums[a2Start++];
            }
        }

        while (a1Start <= a1End) {
            mergeArr[i++] = nums[a1Start++];
        }

        while (a2Start <= a2End) {
            mergeArr[i++] = nums[a2Start++];
        }

        for (int j = 0; j < mergeArr.length; j++) {
            nums[start + j] = mergeArr[j];
        }

        return ans;
    }

}

public class LeetCode_51_LCOF {

    public static void main(String[] args) {
        LeetCode_51_Solution solution = new LeetCode_51_Solution();
        System.out.println(solution.reversePairs(new int[]{7, 5, 6, 4}));
    }

}
