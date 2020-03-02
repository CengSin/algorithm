package com.company.simple;

import java.util.Arrays;

/**
 * @description: 字符串相加
 * @author: 15262
 * @date: 2020/3/2
 */

class LeetCode_415_Solution {
    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) return null;
        while (num1.length() < num2.length()) {
            num1 = "0" + num1;
        }

        while (num1.length() > num2.length()) {
            num2 = "0" + num2;
        }

        int[] sumArr = new int[5101];
        int k = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            sumArr[k++] = (num1.charAt(i) + num2.charAt(i) - 96);
        }
        for (int i = 0; i < k; i++) {
            if (sumArr[i] > 9) {
                sumArr[i + 1] = sumArr[i + 1] + (sumArr[i] / 10);
                sumArr[i] %= 10;
            }
        }
        for (int i = k; i < sumArr.length && sumArr[k] != 0; i++) {
            k++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = k - 1; i >= 0; i--) {
            sb.append(sumArr[i]);
        }
        return sb.toString();
    }
}

public class LeetCode_415_AddStrings {

    public static void main(String[] args) {
        LeetCode_415_Solution solution = new LeetCode_415_Solution();
        /*System.out.println(solution.addStrings("1", "2"));
        System.out.println(solution.addStrings("1", "9"));
        System.out.println(solution.addStrings("999", "9"));
        System.out.println(solution.addStrings("0", "0"));
        System.out.println(solution.addStrings("5100", "5100"));*/
        System.out.println(solution.addStrings("9", "99"));
    }

}
