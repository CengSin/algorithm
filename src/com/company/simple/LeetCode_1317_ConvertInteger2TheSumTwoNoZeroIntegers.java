package com.company.simple;

import java.util.Arrays;

/**
 * @description:  将整数转换为两个无零整数的和
 * @author: 15262
 * @date: 2020/3/21
 */

class LeetCode_1317_Solution {

    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        int j = n - 1;
        while (i < j) {
            if (notContainsZero(i) && notContainsZero(j)) {
                break;
            }
            i = i + 1;
            j = j - 1;
        }
        return new int[]{i, j};
    }

    private boolean notContainsZero(int j) {
        while (j != 0) {
            int tmp = j % 10;
            if (tmp == 0) {
                return false;
            }
            j /= 10;
        }
        return true;
    }

}

public class LeetCode_1317_ConvertInteger2TheSumTwoNoZeroIntegers {

    public static void main(String[] args) {
        LeetCode_1317_Solution solution = new LeetCode_1317_Solution();
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(solution.getNoZeroIntegers(1010)));
    }

}
