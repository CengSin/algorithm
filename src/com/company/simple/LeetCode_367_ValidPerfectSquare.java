package com.company.simple;

/**
 * 有效的完全平方数
 */
class LeetCode_367_Solution {

    public boolean isPerfectSquare(int num) {
        if (num < 2) return true;

        long left = 2, right = num / 2;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long l = mid * mid;
            if (l == num) return true;
            if (l > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}

public class LeetCode_367_ValidPerfectSquare {

    public static void main(String[] args) {
        LeetCode_367_Solution solution = new LeetCode_367_Solution();
        System.out.println(solution.isPerfectSquare(16));
        System.out.println(solution.isPerfectSquare(14));
    }

}
