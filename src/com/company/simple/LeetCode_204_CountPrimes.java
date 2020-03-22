package com.company.simple;

import java.util.Arrays;

/**
 * @description: 统计质数
 * @author: 15262
 * @date: 2020/3/22
 */

class LeetCode_204_Solution {
    public int countPrimes(int n) {
        boolean[] isPrimes = new boolean[n + 1];
        Arrays.fill(isPrimes, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrimes[i]) {
                count++;
                for (int j = 2; j * i <= n; j++) {
                    isPrimes[i * j] = false;
                }
            }
        }
        return count;
    }

    private boolean isPrimes(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

public class LeetCode_204_CountPrimes {

    public static void main(String[] args) {
        LeetCode_204_Solution solution = new LeetCode_204_Solution();
        System.out.println(solution.countPrimes(10));
    }

}
