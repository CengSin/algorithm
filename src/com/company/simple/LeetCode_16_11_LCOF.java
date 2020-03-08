package com.company.simple;

import java.util.Arrays;

/**
 * @description: 跳水板问题
 * @author: 15262
 * @date: 2020/3/8
 */

class LeetCode_16_11_Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) return new int[0];
        if (shorter == longer) return new int[]{shorter * k};

        int[] array = new int[k + 1];
        array[0] = shorter * k;
        // 从最小递增到最大，使用for循环，每次short - 1，longer + 1
        int up = longer - shorter;
        for (int i = 1; i <= k; i++) {
            array[i] = array[i - 1] + up;
        }

        return array;
    }
}

public class LeetCode_16_11_LCOF {

    public static void main(String[] args) {
        LeetCode_16_11_Solution solution = new LeetCode_16_11_Solution();
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
        System.out.println(Arrays.toString(solution.divingBoard(1, 1, 3)));
    }

}
