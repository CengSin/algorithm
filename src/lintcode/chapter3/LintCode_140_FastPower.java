package lintcode.chapter3;

/**
 * 快速幂，已经知道当n为偶数的时候，x^n = x^(n/2) * x^(n/2)，所以当n为偶数的时候可以这么求解
 * 当n为奇数的时候，x^n = x^((n-1)/2) * x^((n-1)/2) * x
 *
 * https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode/
 */
class LintCode_140_Solution {
    /**
     * @param a: A 32bit integer
     * @param b: A 32bit integer
     * @param n: A 32bit integer
     * @return: An integer
     */
    public int fastPower(int a, int b, int n) {
        if (n == 0) return 1 % b;
        if (n == 1) return a % b;

        long val = fastPower(a, b, n / 2);
        val = (val * val) % b;
        if (n % 2 == 1) {
            val = (val * a) % b;
        }
        return (int)val;
    }
}

public class LintCode_140_FastPower {
}
