package com.company.simple;

/**
 * @description: 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * @author: 15262
 * @date: 2020/3/1
 */

class LeetCode_258_Solution {

    /**
     * 递归算法
     * @param num
     * @return
     */
    public int addDigits(int num) {
        if (num < 10) return num;

        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }

        return addDigits(sum);
    }

    /**
     * @param num
     * @return
     */
    public int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }
}

public class LeetCode_258_AddDigits {

    public static void main(String[] args) {
        LeetCode_258_Solution solution = new LeetCode_258_Solution();
        System.out.println(solution.addDigits1(38)); // 2
        System.out.println(solution.addDigits1(99)); // 9
        System.out.println(solution.addDigits1(123));  // 6
        System.out.println(solution.addDigits1(4567));  // 4
    }

}

