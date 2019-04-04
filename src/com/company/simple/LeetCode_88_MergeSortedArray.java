package com.company.simple;

import java.util.Arrays;

/**
 * 合并两个有序数组
 */

class Solution_88 {

    private void move(int[] nums1, int startIndex, int endIndex) {
        for (endIndex --; endIndex >= startIndex; --endIndex) {
            nums1[endIndex + 1] = nums1[endIndex];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            for (j = 0; j < m; j++) {
                if (nums1[j] >= nums2[i]) {
                    move(nums1, j, m);
                    nums1[j] = nums2[i];
                    m++;
                    break;
                }
            }
            if (j >= m) {
                nums1[m++] = nums2[i];
            }
        }

    }
}

public class LeetCode_88_MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        Solution_88 s = new Solution_88();
        s.merge(nums1, 3, nums2, 3);

        System.out.println(Arrays.toString(nums1));
    }

}
