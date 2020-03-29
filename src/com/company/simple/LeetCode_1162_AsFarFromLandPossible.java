package com.company.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: 地图分析
 * @author: 15262
 * @date: 2020/3/29
 */

class LeetCode_1162_Solution {

    public int maxDistance(int[][] grid) {
        // 首先把陆地接入队列
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        boolean haveSea = false; // 标识有没有陆地
        int[] point = null;  // 标识有没有海洋
        int[][] move = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        // 循环遍历队列中的点，从该点向外扩散，BFS，碰到陆地就停止，最后遍历到的海洋就是距离陆地最远的海洋，这个海洋肯定是被最近的陆地扩散到的
        while (!queue.isEmpty()) {
            point = queue.poll();
            for (int i = 0; i < move.length; i++) {
                int x = point[0] + move[i][0];
                int y = point[1] + move[i][1];
                if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || grid[x][y] != 0) {
                    continue;
                }
                haveSea = true;
                grid[x][y] = grid[point[0]][point[1]] + 1; // i,j如果为1的话，海洋的初始距离为2
                queue.offer(new int[]{x, y});
            }
        }

        if (point == null || !haveSea) return -1;

        return grid[point[0]][point[1]] - 1; // 距离 - 1
    }

}

public class LeetCode_1162_AsFarFromLandPossible {

    public static void main(String[] args) {
        LeetCode_1162_Solution solution = new LeetCode_1162_Solution();
        System.out.println(solution.maxDistance(new int[][]{
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        }));

        System.out.println(solution.maxDistance(new int[][]{
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        }));
    }

}
