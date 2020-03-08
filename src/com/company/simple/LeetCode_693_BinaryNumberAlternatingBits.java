package com.company.simple;

/**
 * @description: 交替位二进制数，相邻两位永不相等
 * @author: 15262
 * @date: 2020/3/8
 */
class LeetCode_693_Solution {
    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            int last = n & 1;
            n = n >> 1;
            int cur = n & 1;
            if (last == cur) {
                return false;
            }
        }
        return true;
    }
}

public class LeetCode_693_BinaryNumberAlternatingBits {

    public static void main(String[] args) {
        LeetCode_693_Solution solution = new LeetCode_693_Solution();
        assert solution.hasAlternatingBits(5);
        assert !solution.hasAlternatingBits(7);
        assert !solution.hasAlternatingBits(11);
        assert solution.hasAlternatingBits(10);
    }

}
