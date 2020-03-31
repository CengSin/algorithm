package com.company.simple;

import java.util.Arrays;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/31
 */

class LeetCode_1089_Solution {

    public void duplicateZeros(int[] arr) {
        int len = arr.length;
        // 如果碰到0，就把所有元素往右边移动
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0 && i < len - 1) {
                int tmp = len - 2;
                while (tmp > i) {
                    arr[tmp + 1] = arr[tmp];
                    tmp--;
                }
                arr[i + 1] = 0;
                i++;
            }
        }
    }

}

public class LeetCode_1089_DuplicateZeros {

    public static void main(String[] args) {
        LeetCode_1089_Solution solution = new LeetCode_1089_Solution();
        int[] arr = new int[]{0, 0, 0, 0, 0, 0};
        solution.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }

}
