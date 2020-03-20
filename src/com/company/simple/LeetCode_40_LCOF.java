package com.company.simple;

import java.util.Arrays;

/**
 * @description: 最小的k个数
 * @author: 15262
 * @date: 2020/3/20
 */
class LeetCode_40_Solution {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}

public class LeetCode_40_LCOF {

    public static void main(String[] args) {

    }

}
