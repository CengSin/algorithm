package com.company.simple;

import java.util.Arrays;

/**
 * @description: 分式化简
 * @author: 15262
 * @date: 2020/3/26
 */

class LeetCode_LCP2_Solution {
    public int[] fraction(int[] cont) {
        int m = 1, n = cont[cont.length - 1], result[] = {m, n};
        for (int i = cont.length - 2; i >= 0; i--) {
            result[0] += result[1] * cont[i];
            swap(result);
        }
        swap(result);
        return result;
    }

    private void swap(int[] result) {
        result[0] += result[1];
        result[1] = result[0] - result[1];
        result[0] = result[0] - result[1];
    }
}

public class LeetCode_LCP2_DeepDarkFraction {

    public static void main(String[] args) {
        LeetCode_LCP2_Solution solution = new LeetCode_LCP2_Solution();
        System.out.println(Arrays.toString(solution.fraction(new int[]{3, 2, 0, 2})));
    }

}
