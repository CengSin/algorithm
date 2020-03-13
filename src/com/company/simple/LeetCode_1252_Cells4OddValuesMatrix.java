package com.company.simple;

/**
 * @description: 奇数值单元格的数据
 * @author: 15262
 * @date: 2020/3/13
 */

class LeetCode_1252_Solution {

    /**
     * 统计行数和列数出现的结果
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCellsNew(int n, int m, int[][] indices) {
        int[] row = new int[n];
        int[] col = new int[m];

        /**
         * 通过统计行，列的操作次数，可以得出二维数组中每个位操作了几次，将行列操作次数加起来 % 2 ！= 0的则为奇数
         */
        for (int i = 0; i < indices.length; i++) {
            row[indices[i][0]] ++;
            col[indices[i][1]] ++;
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((row[i] + col[j]) % 2 != 0) {
                    ans ++;
                }
            }
        }

        return ans;
    }

    /**
     * 直接计算得出结果
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];

        for (int i = 0; i < indices.length; i++) {
            // 指定行indices[i][0]的值 ++
            int row = indices[i][0];
            for (int j = 0; j < arr[row].length; j++) {
                arr[row][j] ++;
            }
            // 指定列indices[i][1]的值 ++
            int column = indices[i][1];
            for (int j = 0; j < arr.length; j++) {
                arr[j][column] ++;
            }
        }

        int num = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 != 0) {
                    num ++;
                }
            }
        }

        return num;
    }
}

public class LeetCode_1252_Cells4OddValuesMatrix {

    public static void main(String[] args) {
        LeetCode_1252_Solution solution = new LeetCode_1252_Solution();
        System.out.println(solution.oddCellsNew(2, 3, new int[][]{{0, 1}, {1, 1}}));
        System.out.println(solution.oddCellsNew(2, 2, new int[][]{{1, 1}, {0, 0}}));
    }

}
