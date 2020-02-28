package com.company.simple;

/**
 * @description: 颠倒二进制位
 * 颠倒给定的 32 位无符号整数的二进制位。在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 *
 * 类似于之前的字符串翻转问题，将二进制每一位往后移动31 -i的长度即可等于颠倒之后的字符串
 *
 * 题解：
 *
 * 通过数字与1相与拿到数字的每一位二进制，之后通过左移（31 -i）的位置，将该二进制位转为最终位置的十进制表示，并与之前的相加。之后n >> 1，用来拿下一个二进制位
 *
 * @author: 15262
 * @date: 2020/2/28
 */
class LeetCode_190_Solution {
    public int reverseBits(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = n & 1;
            sum = sum + (tmp << (31 - i));
            n = n >> 1;
        }
        return sum;
    }
}

public class LeetCode_190_ReverseBits {

    public static void main(String[] args) {
        LeetCode_190_Solution solution = new LeetCode_190_Solution();
        System.out.println(solution.reverseBits(-3));
        System.out.println(solution.reverseBits(43261596));
    }

}
