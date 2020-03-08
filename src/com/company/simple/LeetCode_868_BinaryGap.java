package com.company.simple;

/**
 * @description: 二进制间距
 * @author: 15262
 * @date: 2020/3/8
 */
class LeetCode_868_Solution {

    public int binaryGap(int N) {
        int last = -1;  // 上一个1的位置
        int maxLen = 0; // 1的最大间隔
        for (int j = 0; j < 32; j++) { // 32表示 2^32次方，循环拿N的2进制位
            if (((N >> j) & 1) == 1) {
                if (last != -1) {
                    maxLen = Math.max(j - last, maxLen);
                }
                last = j;
            }
        }
        return maxLen;
    }
}

public class LeetCode_868_BinaryGap {

    public static void main(String[] args) {
        LeetCode_868_Solution solution = new LeetCode_868_Solution();
        assert solution.binaryGap(22) == 2;
        assert solution.binaryGap(5) == 2;
        assert solution.binaryGap(6) == 1;
        assert solution.binaryGap(8) == 0;
        assert solution.binaryGap(16) == 0;
        assert solution.binaryGap(15) == 1;
    }

}
