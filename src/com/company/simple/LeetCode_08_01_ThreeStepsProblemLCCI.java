package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/29
 */

class LeetCode_08_01_Solution {

    private static long[] cache;

    private static final int REMAINDER = 1000000007;

    public LeetCode_08_01_Solution() {
        this.cache = new long[1000000];
        this.cache[0] = 0;
        this.cache[1] = 1;
        this.cache[2] = 2;
        this.cache[3] = 4;
        this.cache[4] = 7;
        this.cache[5] = 13;
    }

    public int waysToStep(int n) {
        if (cache[n] == 0 && n > 5) {
            int tmp = n;
            while (cache[--tmp] == 0) {
            }
            for (int i = tmp + 1; i <= n; i++) {
                cache[i] = (cache[i - 1] + cache[i - 2] + cache[i - 3]) % REMAINDER;
            }
        }
        return (int) cache[n];
    }
}

public class LeetCode_08_01_ThreeStepsProblemLCCI {

    public static void main(String[] args) {
        LeetCode_08_01_Solution solution = new LeetCode_08_01_Solution();
        System.out.println(solution.waysToStep(61));
        System.out.println(solution.waysToStep(3));
    }

}
