package com.company.may;

class LeetCode_50_Solution {
    public double myPow(double x, int n) {
        // 判断n是否小于0
        long N = n;
        if (n < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double val = fastPow(x, n / 2);
        if (n % 2 == 1) {
            return val * val * x;
        }
        return val * val;
    }
}

public class LeetCode_50_PowXN {
}
