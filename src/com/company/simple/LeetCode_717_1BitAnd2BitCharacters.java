package com.company.simple;

/**
 * @description: 一比特字符和二比特字符
 * @author: 15262
 * @date: 2020/3/1
 */

class LeetCode_717_Solution {

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] == 1) {
                i ++;
                continue;
            }
            if (i == bits.length - 1 && bits[i] == 0) {
                return true;
            }
        }
        return false;
    }
}

public class LeetCode_717_1BitAnd2BitCharacters {

    public static void main(String[] args) {
        LeetCode_717_Solution solution = new LeetCode_717_Solution();
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 0}));  // true
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 0}));  // false
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 0, 1, 0}));  // false
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 0, 0, 0})); // true
        System.out.println(solution.isOneBitCharacter(new int[]{1, 1, 1, 1, 0})); // true
        System.out.println(solution.isOneBitCharacter(new int[]{1, 0, 1, 0, 0})); //true
    }

}
