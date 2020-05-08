package com.company.may;

class LeetCode_221_Solution {

    /**
     * 计算面积最大的正方形
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int maxArea = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return maxArea;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    maxArea = Math.max(maxArea, getAreaByStart(matrix, i, j));
                }
            }
        }
        return maxArea;
    }

    private int getAreaByStart(char[][] matrix, int i, int j) {
        int k = 0;
        for (; k + i < matrix.length && k + j < matrix[i].length; k++) {
            for (int l = j; l <= k + j; l++) {
                if (matrix[k + i][l] != '1') return k * k;
            }

            for (int l = i; l < k + i; l++) {
                if (matrix[l][k + j] != '1') return k * k;
            }
        }
        return k * k;
    }

}

public class LeetCode_221_MaximalSquare {
}
