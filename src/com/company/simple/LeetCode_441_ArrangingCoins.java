package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/4
 */

class LeetCode_441_Solution {
    public int arrangeCoins(int n) {
        if (n == 0) return 0;
        int i = 1;
        while (true) {
            n = n - i;
            if (n <= i) {
                break;
            }
            i++;
        }
        return i;
    }
}

public class LeetCode_441_ArrangingCoins {

    public static void main(String[] args) {
        LeetCode_441_Solution solution = new LeetCode_441_Solution();
        System.out.println(solution.arrangeCoins(0));
        System.out.println(solution.arrangeCoins(1));
        System.out.println(solution.arrangeCoins(5));
        System.out.println(solution.arrangeCoins(8));
    }

}
