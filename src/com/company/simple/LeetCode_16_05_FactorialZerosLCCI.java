package com.company.simple;

/**
 * @description: 阶乘尾数0的个数
 * @author: 15262
 * @date: 2020/4/2
 */

class LeetCode_16_05_Solution {

    public int trailingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    private int timeOutAns(int n) {
        if (n < 5) return 0;
        int sum = 0;
        for (int i = 5; i <= n; i+=5) {
            int tmp = i;
            while (tmp % 5 == 0 && tmp >= 5) {
                tmp = tmp / 5;
                sum++;
            }
        }
        return sum;
    }

}

public class LeetCode_16_05_FactorialZerosLCCI {

    public static void main(String[] args) {
        LeetCode_16_05_Solution solution = new LeetCode_16_05_Solution();
        /*System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(10));
        System.out.println(solution.trailingZeroes(15));
        System.out.println(solution.trailingZeroes(20));
        System.out.println(solution.trailingZeroes(25));
        System.out.println(solution.trailingZeroes(30));*/
        System.out.println(solution.trailingZeroes(1808548329));
    }

}
