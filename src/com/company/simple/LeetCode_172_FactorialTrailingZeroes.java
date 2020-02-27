package com.company.simple;

class LeetCode_172_Solution {
    public int trailingZeroes(int n) {
        if (n >= 5) {
            return (n / 5) + trailingZeroes(n / 5);
        }
        return 0;
    }
}

public class LeetCode_172_FactorialTrailingZeroes {

    public static void main(String[] args) {
        LeetCode_172_Solution solution = new LeetCode_172_Solution();
        System.out.println(solution.trailingZeroes(3));
        System.out.println(solution.trailingZeroes(5));
        System.out.println(solution.trailingZeroes(10));
        System.out.println(solution.trailingZeroes(15));
        System.out.println(solution.trailingZeroes(20));
        System.out.println(solution.trailingZeroes(25));
    }

}
