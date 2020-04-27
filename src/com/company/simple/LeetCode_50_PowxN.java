package com.company.simple;

/**
 * x^n = {n % 2 == 0? x^1/2n * x^1/2n : x^1/2n*x^1/2n*x}
 */
class LeetCode_50_Solution {
    public double myPow(double x, int n) {
        long N = n;
        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long N) {
        if (N == 0) return 1;
        if (N == 1) return x;
        double val = fastPow(x, N/2);
        if (N % 2 == 1) {
            return val * val * x;
        }
        return val * val;
    }
}

public class LeetCode_50_PowxN {
}
