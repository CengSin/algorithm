package com.company.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 岛屿的数量，简单图，路径长固定为1，BFS问题
 */
class LeetCode_200_Solution {

    private final int[][] move = new int[][]{
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    /**
     * 根据二维数组中的每个为1的点宽度遍历其周围点，之后计数
     *
     * @param grid
     * @return
     */
    public int numIslands(final char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        boolean[][] bolGrid = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                bolGrid[i][j] = grid[i][j] == '1';
            }
        }

        int count = 0;
        for (int i = 0; i < bolGrid.length; i++) {
            for (int j = 0; j < bolGrid[i].length; j++) {
                if (bolGrid[i][j]) {
                    count++;
                    // bfs(bolGrid, i, j);
                    recursion(bolGrid, i, j);
                }
            }
        }
        return count;
    }

    private void recursion(boolean[][] bolGrid, int i, int j) {
        if (!(i >= 0 && j >= 0 && i < bolGrid.length && j < bolGrid[i].length && bolGrid[i][j])) return;
        bolGrid[i][j] = false;
        recursion(bolGrid, i, j - 1);
        recursion(bolGrid, i, j + 1);
        recursion(bolGrid, i - 1, j);
        recursion(bolGrid, i + 1, j);
    }

    private void bfs(boolean[][] bolGrid, int i, int j) {
        Queue<int[]> position = new LinkedList<>();
        int[] point = {i, j};
        position.offer(point);
        bolGrid[point[0]][point[1]] = false;
        while (!position.isEmpty()) {
            point = position.poll();

            for (int k = 0; k < move.length; k++) {
                int newI = point[0] + move[k][0];
                int newJ = point[1] + move[k][1];
                if (newI >= 0 && newJ >= 0 && newI < bolGrid.length && newJ < bolGrid[newI].length && bolGrid[newI][newJ]) {
                    position.offer(new int[]{newI, newJ});
                    // 必须在放进去的时候就要设置该点为false，否则在遍历寻遍的时候会出现环，导致重复像队列中添加数据
                    bolGrid[newI][newJ] = false;
                }
            }
        }
    }

}

public class LeetCode_200_NumberOfIslands {

    public static void main(String[] args) {
        LeetCode_200_Solution solution = new LeetCode_200_Solution();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(solution.numIslands(grid));

        char[][] grid1 = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'},
        };
        System.out.println(solution.numIslands(grid1));
    }

}
