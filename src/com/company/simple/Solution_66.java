package com.company.simple;

import java.util.Arrays;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *
 * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 */
public class Solution_66 {

    private int[] move(int[] digits, int len) {
        int[] newArray = new int[len+1];
        newArray[0] = 1;
        for (int i = 0; i < len; i++) {
            newArray[i+1] = digits[i];
        }
        return newArray;
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length;
        digits[len-1] ++;
        for (len--; len>=0; --len) {
            if (digits[len] >= 10) {
                digits[len] = digits[len] % 10;
                if (len > 0){
                    digits[len-1] = digits[len-1] + 1;
                } else {
                    digits = move(digits, digits.length);
                }
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution_66 s = new Solution_66();
        int[] test1 = new int[]{1,2,3};
        int[] test2 = new int[]{0};
        int[] test3 = new int[]{9,9,9};
        int[] test4 = new int[]{1,0,0, 1};
        int[] test5 = new int[]{1,0,0, 2};
        System.out.println(Arrays.toString(s.plusOne(test1)));
        System.out.println(Arrays.toString(s.plusOne(test2)));
        System.out.println(Arrays.toString(s.plusOne(test3)));
        System.out.println(Arrays.toString(s.plusOne(test4)));
        System.out.println(Arrays.toString(s.plusOne(test5)));
    }

}
