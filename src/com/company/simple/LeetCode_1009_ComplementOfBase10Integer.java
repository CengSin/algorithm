package com.company.simple;

/**
 * @description: 十进制整数的反码
 * @author: zhangzetao
 * @date: 2020/3/16
 */

class LeetCode_1009_Solution {

    /**
     * 反码（补数） = 二进制位全为1的数 - 原数 - 1
     * @param N
     * @return
     */
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int num = 1;

        int tmp = N;

        //求该数的二进制全为1的数字
        while (tmp != 0) {
            num = num << 1;
            tmp = tmp >> 1;
        }

        return num - N - 1;
    }
}

public class LeetCode_1009_ComplementOfBase10Integer {

    public static void main(String[] args) {
        LeetCode_1009_Solution solution = new LeetCode_1009_Solution();
        System.out.println(solution.bitwiseComplement(5));
        System.out.println(solution.bitwiseComplement(7));
        System.out.println(solution.bitwiseComplement(10));
        System.out.println(solution.bitwiseComplement(100));
    }

}
