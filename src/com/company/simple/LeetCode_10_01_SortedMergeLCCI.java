package com.company.simple;

/**
 * @description: 合并排序后的数组
 * @author: 15262
 * @date: 2020/3/3
 */

class LeetCode_10_01_Solution {
    public void merge(int[] A, int m, int[] B, int n) {
        int[] swap = new int[A.length];

        int k = 0;
        int i = 0, j = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                swap[k++] = A[i++];
            } else {
                swap[k++] = B[j++];
            }
        }

        while (i < m) {
            swap[k ++] = A[i++];
        }

        while (j < n) {
            swap[k ++] = B[j++];
        }

        for (int l = 0; l < swap.length; l++) {
            A[l] = swap[l];
        }
    }
}

public class LeetCode_10_01_SortedMergeLCCI {

    public static void main(String[] args) {
        LeetCode_10_01_Solution solution = new LeetCode_10_01_Solution();
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        solution.merge(a, 3, b, 3);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
