package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/2/28
 */
class LeetCode_191_Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int tmp = 0;
        while (n != 0) {
            tmp += n & 1;
            n = n >>> 1;
        }
        return tmp;
    }
}

public class LeetCode_191_NumberOfOneBits {

    public static void main(String[] args) {
        LeetCode_191_Solution solution = new LeetCode_191_Solution();
        System.out.println(solution.hammingWeight(3));
        System.out.println(solution.hammingWeight(1));
        System.out.println(solution.hammingWeight(-3));
    }

}
