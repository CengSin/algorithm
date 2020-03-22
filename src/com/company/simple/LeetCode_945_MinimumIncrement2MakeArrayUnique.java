package com.company.simple;

/**
 * @description: 使数组唯一的最小增量
 * @author: 15262
 * @date: 2020/3/22
 */

class LeetCode_945_Solution {
    public int minIncrementForUnique(int[] A) {
        int[] flags = new int[80000];

        for (int i : A) {
            flags[i]++;
        }

        int move = 0, count = 0;
        for (int i = 0; i < flags.length; i++) {
            if (flags[i] > 1) {
                move -= (i * (flags[i] - 1)); // 要移动的元素格式
                count += flags[i] - 1;
            } else if (count > 0 && flags[i] == 0) {
                count --;
                move += i;
            }
        }

        return move;
    }
}

public class LeetCode_945_MinimumIncrement2MakeArrayUnique {

    public static void main(String[] args) {
        LeetCode_945_Solution solution = new LeetCode_945_Solution();
        // System.out.println(solution.minIncrementForUnique(new int[]{1, 2, 2}));
        System.out.println(solution.minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
        System.out.println(solution.minIncrementForUnique(new int[]{2, 3, 3, 5, 5, 5, 5, 3, 2, 4}));
    }

}
