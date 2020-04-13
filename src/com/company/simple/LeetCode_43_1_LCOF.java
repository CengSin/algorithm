package com.company.simple;

import java.util.Stack;

/**
 * 计算0~n范围内有多少个1出现
 */
class LeetCode_43_1_LCOFSolution {

    public int countDigitOne(int n) {
        long[] f = new long[11];
        f[0] = 0;
        f[1] = 1;
        // 初始化位数的值
        for (int i = 2; i < 11; i++) {
            f[i] = (long) Math.pow(10, i - 1) + 10 * f[i - 1];
        }

        Stack<Integer> stack = new Stack<>();
        while (n != 0) {
            stack.push(n % 10);
            n /= 10;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            int top = stack.pop();
            if (size == 1) {
                if (top != 0) res += f[1];
            } else {
                if (top > 1) res += Math.pow(10, stack.size());
                else if (top == 1) {
                    res += getRest((Stack)stack.clone());
                }
                res += top * f[size - 1];
            }
        }
        return res;
    }

    private int getRest(Stack<Integer> stack) {
        int res = 0;
        while (!stack.isEmpty()) {
            res = res * 10 + stack.pop();
        }
        return res + 1;
    }

}

public class LeetCode_43_1_LCOF {

    public static void main(String[] args) {
        LeetCode_43_1_LCOFSolution solution = new LeetCode_43_1_LCOFSolution();
        System.out.println(solution.countDigitOne(12));
        System.out.println(solution.countDigitOne(2345));
        System.out.println(solution.countDigitOne(1045));
    }

}
