package com.company.simple;

/**
 * @description: 斐波那契额数列
 * @author: 15262
 * @date: 2020/4/3
 */

class LeetCode_509_Solution {

    public int fib(int N) {
        int a = 0;
        int b = 1;
        int sum = 0;
        while (N-- > 0) {
            sum = a + b;
            a = a + b;
            b = a - b;
        }
        return sum;
    }

}

public class LeetCode_509_FibonacciNumber {

    public static void main(String[] args) {
        LeetCode_509_Solution solution = new LeetCode_509_Solution();
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(6));
    }

}
