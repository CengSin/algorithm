package com.company.simple;

/**
 * 寻找两个有序数组的中位数
 */

class LeetCode_4_Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int[] resArr = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                resArr[k++] = nums1[i++];
            } else {
                resArr[k++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            resArr[k++] = nums1[i++];
        }

        while (j < nums2.length) {
            resArr[k++] = nums2[j++];
        }

        if (resArr.length % 2 > 0) {
            return resArr[resArr.length / 2];
        }
        int middle = resArr.length / 2;
        return (resArr[middle] + resArr[middle - 1]) * 1.0 / 2;
    }
}

public class LeetCode_4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        LeetCode_4_Solution solution = new LeetCode_4_Solution();
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

}
