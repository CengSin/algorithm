package com.company.simple;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @description: 01矩阵
 * @author: 15262
 * @date: 2020/4/6
 */

class LeetCode_542_Solution_Dp {

    /**
     * 动态规划解决01矩阵问题，给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。matrix[i][j] = Math.min(上下左右, 自己) + 1
     * 其中，从上方向下方要检查ij的左边和上边，还要有一次从下方往上遍历，用来检查>=ij的位置中的0元素
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {

        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int[] ints : dp) {
            for (int i = 0; i < ints.length; i++) {
                ints[i] = Integer.MAX_VALUE - 100000;
            }
        }

        // 从上往下遍历
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                } else {
                    if (i > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - 1] + 1);
                    }
                }
            }
        }

        // 从下往上遍历
        for (int i = matrix.length - 1; i >= 0; i--) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (i < matrix.length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i + 1][j] + 1);
                }
                if (j < matrix[i].length - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][j + 1] + 1);
                }
            }
        }

        return dp;
    }
}

class LeetCode_542_Solution {

    // 表示一个位置要移动到上下左右的时候，ij的变化幅度
    private final int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    bfs(matrix, i, j);
                }
            }
        }
        return matrix;
    }

    private void bfs(int[][] matrix, int i, int j) {
        // 首先将初始节点添加到队列中
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        int size = queue.size();
        int level = 0;

        while (size > 0) {
            Map<Integer, Integer> hashMap = new HashMap<>();
            level++;
            for (int k = 0; k < size; k++) {
                int[] point = queue.poll();
                for (int[] ints : move) {
                    int newI = point[0] + ints[0];
                    int newJ = point[1] + ints[1];
                    if (newI >= 0 && newI < matrix.length && newJ < matrix[newI].length && newJ >= 0) {
                        if (matrix[newI][newJ] > 0) {
                            if (!(hashMap.containsKey(newI) && hashMap.get(newI) == newJ)) {
                                int[] newPoint = {newI, newJ};
                                queue.offer(newPoint);
                                hashMap.put(newI, newJ);
                            }
                        } else {
                            matrix[i][j] = level;
                            return;
                        }
                    }
                }
            }
            size = queue.size();
        }
    }

}

public class LeetCode_542_01Matrix {

    public static void main(String[] args) {
        LeetCode_542_Solution solution = new LeetCode_542_Solution();
        LeetCode_542_Solution_Dp solution2 = new LeetCode_542_Solution_Dp();
        solution.updateMatrix(new int[][]{{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}});
        solution2.updateMatrix(new int[][]{{1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}});
    }

}
