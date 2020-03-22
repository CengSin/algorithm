package com.company.simple;

/**
 * @description: 统计矩阵中的负数
 * @author: 15262
 * @date: 2020/3/22
 */

class LeetCode_1351_Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int[] grids : grid) {
            for (int i : grids) {
                if (i < 0) {
                    count ++;
                }
            }
        }
        return count;
    }
}

public class LeetCode_1351_CountNegativeNumbersSortedMatrix {

    public static void main(String[] args) {
        LeetCode_1351_Solution solution = new LeetCode_1351_Solution();
        System.out.println(solution.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    }

}
