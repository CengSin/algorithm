package lintcode;

import java.util.LinkedList;
import java.util.Queue;

class LintCode_433_Solution {
    /**
     * @param grid: a boolean 2D matrix
     * @return: an integer
     */
    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0) return 0;
        boolean[][] matrix = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = grid[i][j];
            }
        }

        // 深度遍历 | 广度遍历
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]) {
                    count ++;
                    // bfs(matrix, i, j);
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(boolean[][] matrix, int i, int j) {
        if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || !matrix[i][j])
            return;
        matrix[i][j] = false;
        dfs(matrix, i + 1, j);
        dfs(matrix, i - 1, j);
        dfs(matrix, i, j + 1);
        dfs(matrix, i, j - 1);
    }

    private final int[][] move = {
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    private void bfs(boolean[][] matrix, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        matrix[i][j] = false;
        while (!queue.isEmpty()) {
            int[] island = queue.poll();
            for (int k = 0; k < move.length; k++) {
                int newI = island[0] + move[k][0];
                int newJ = island[1] + move[k][1];
                if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[newI].length || !matrix[newI][newJ])
                    continue;
                queue.offer(new int[]{newI, newJ});
                matrix[newI][newJ] = false;
            }
        }
    }
}

public class LintCode_433_NumberOfIslands {
}
