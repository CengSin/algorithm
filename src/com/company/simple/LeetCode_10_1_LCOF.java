package com.company.simple;

/**
 * @description: 斐波那契额数列
 * @author: 15262
 * @date: 2020/3/8
 */

class LeetCode_10_1_Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int pre = 1;
        int cur = 1;
        for (int i = 2; i < n; i++) {
            int tmp = (pre + cur) % 1000000007;
            pre = cur;
            cur = tmp;
        }
        return cur;
    }
}

public class LeetCode_10_1_LCOF {

    public static void main(String[] args) {
        LeetCode_10_1_Solution solution = new LeetCode_10_1_Solution();
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(10));
        System.out.println(solution.fib(45));
    }

}
