package com.company.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */

class LeetCode_13_LCOF_Solution {

    public int movingCountNew(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(0, 0, m, n, k, visited);
    }

    private int dfs(int i, int j, int m, int n, int k, boolean visited[][]) {
        if (i < 0 || i >= m || j < 0 || j >= n || (i/10 + i%10 + j/10 + j%10) > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i + 1, j, m, n, k, visited) + dfs(i - 1, j, m, n, k, visited) +
                dfs(i, j + 1, m, n, k, visited) + dfs(i, j - 1, m, n, k, visited) + 1;
    }

    private int[][] move = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };

    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        return bfs(0, 0, m, n, k);
    }

    private int bfs(int i, int j, int m, int n, int k) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] flagArr = new int[m][n];
        if (lessThanK(i, j, k)) {
            queue.offer(new int[]{i, j});
            flagArr[i][j] = 1;
        }
        int count = queue.size();

        while (count != 0) {

            for (int l = 0; l < count; l++) {
                int[] point = queue.poll();
                for (int o = 0; o < move.length; o++) {
                    int newI = point[0] + move[o][0];
                    int newJ = point[1] + move[o][1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n && lessThanK(newI, newJ, k) && flagArr[newI][newJ] == 0) {
                        // 去重
                        queue.offer(new int[]{newI, newJ});
                        flagArr[newI][newJ] = 1;
                    }
                }
            }
            count = queue.size();
        }

        int sum = 0;
        for (int l = 0; l < m; l++) {
            for (int o = 0; o < n; o++) {
                if (flagArr[l][o] > 0) {
                    sum++;
                }
            }
        }
        return sum;
    }

    private boolean lessThanK(int i, int j, int k) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }

        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum <= k;
    }

}

public class LeetCode_13_LCOF_AndroidMoveLen {

    public static void main(String[] args) {
        LeetCode_13_LCOF_Solution solution = new LeetCode_13_LCOF_Solution();
        System.out.println(solution.movingCount(3, 2, 1));
    }

}
