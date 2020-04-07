package com.company.simple;

class LeetCode_9_Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x;
        int tmp = 0;
        while (x != 0) {
            tmp *= 10;
            tmp += x % 10;
            x /= 10;
        }
        return num == tmp;
    }

}

public class LeetCode_9_PalindromeNumber {

    public static void main(String[] args) {
        LeetCode_9_Solution solution = new LeetCode_9_Solution();
        System.out.println(solution.isPalindrome(121));
        System.out.println(solution.isPalindrome(-121));
        System.out.println(solution.isPalindrome(10));
    }

}
