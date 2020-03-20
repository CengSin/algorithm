package com.company.simple;

/**
 * @description: 整数转换
 * @author: 15262
 * @date: 2020/3/20
 */

class LeetCode_05_06_Solution {
    public int convertInteger(int A, int B) {
        int cnt = 0;
        while (A != 0 || B != 0) {
            if ((A & 1) != (B & 1)) cnt++;
            A = A >>> 1;
            B = B >>> 1;
        }
        return cnt;
    }
}

public class LeetCode_05_06_LCOF {

    public static void main(String[] args) {
        LeetCode_05_06_Solution solution = new LeetCode_05_06_Solution();
        System.out.println(solution.convertInteger(29, 15));
        System.out.println(solution.convertInteger(1, 2));
    }

}
