package com.company.simple;

/**
 * @description: 配对交换
 * @author: 15262
 * @date: 2020/4/2
 */

class LeetCode_05_07_Solution {

    private final static int oddIndex = 0x55555555;
    private final static int evenIndex = 0xaaaaaaaa;

    public int exchangeBits(int num) {
        return (num & oddIndex) << 1 | (num & evenIndex) >> 1;
    }

}

public class LeetCode_05_07_ExchangeLCCI {

    public static void main(String[] args) {
        LeetCode_05_07_Solution solution = new LeetCode_05_07_Solution();
        System.out.println(solution.exchangeBits(3));
    }

}
