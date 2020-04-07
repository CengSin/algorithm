package com.company.simple;

import java.util.Arrays;

/**
 * @description: 旋转矩阵
 * @author: 15262
 * @date: 2020/4/7
 */

class LeetCode_01_07_Solution {

    public void rotate(int[][] matrix) {
        int[][] rotate = new int[matrix.length][matrix.length];
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                rotate[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                matrix[i][j] = rotate[i][j];
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
