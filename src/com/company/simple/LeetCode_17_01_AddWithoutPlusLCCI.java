package com.company.simple;

/**
 * @description: 不使用运算符做加法
 * @author: 15262
 * @date: 2020/3/2
 */

class LeetCode_17_01_Solution {
    public int add(int a, int b) {

        while (b != 0) {
            int sum = (a ^ b);
            int carry = (a & b) << 1;
            a = sum;
            b = carry;
        }

        return a;
    }
}

public class LeetCode_17_01_AddWithoutPlusLCCI {

    public static void main(String[] args) {
        LeetCode_17_01_Solution solution = new LeetCode_17_01_Solution();
        solution.add(1, 2);
        solution.add(1, -1);
        solution.add(0, 0);
        solution.add(1, 9);
        solution.add(1, 99);
        solution.add(99, 99);
    }

}
