package com.company.simple;

import java.util.Arrays;

/**
 * @description: 旋转矩阵
 * @author: 15262
 * @date: 2020/4/7
 */

class LeetCode_01_07_Solution {

    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dest = new int[row][col];
        for (int i = 0, newCol = matrix.length - 1; i < row; i++, newCol --) {
            for (int j = 0; j < col; j++) {
                dest[j][newCol] = matrix[i][j];
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = dest[i][j];
            }
        }
    }

}

public class LeetCode_01_07_RotateMatrixLCCI {

    public static void main(String[] args) {
        LeetCode_01_07_Solution solution = new LeetCode_01_07_Solution();
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
        solution.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

}
