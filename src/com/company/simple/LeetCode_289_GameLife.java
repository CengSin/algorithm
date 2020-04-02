package com.company.simple;

import java.util.Arrays;

/**
 * @description: 元胞自动机
 * @author: 15262
 * @date: 2020/4/2
 */

class LeetCode_289_Solution {

    /**
     * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
     * <p>
     * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     * <p>
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
     *
     * @param board
     */
    public void gameOfLife(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];
        /*保留数组的备份，以保证修改的过程是*同步*的，不会因为相邻位子元素状态的修改收到影响*/
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                copy[i][j] = board[i][j];
            }
        }

        // 周围八个元素的位子
        int[][] move = new int[][]{
                {-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int cnt = countLifeCell(i, j, copy, move);
                if (copy[i][j] == 1 && cnt < 2) {
                    board[i][j] = 0;
                } else if (copy[i][j] == 1 && cnt > 3) {
                    board[i][j] = 0;
                } else if (copy[i][j] == 0 && cnt == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    private int countLifeCell(int i, int j, int[][] board, int[][] move) {
        int sum = 0;
        for (int k = 0; k < move.length; k++) {
            int newI = i + move[k][0];
            int newJ = j + move[k][1];
            if (newI >= 0 && newI < board.length && newJ >= 0 && newJ < board[newI].length && board[newI][newJ] == 1) {
                sum++;
            }
        }
        return sum;
    }

}

public class LeetCode_289_GameLife {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        LeetCode_289_Solution solution = new LeetCode_289_Solution();
        solution.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }

}
