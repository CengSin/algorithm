package com.company.simple;

/**
 * @description: 三维形体的表面积
 * @author: zhangzetao
 * @date: 2020/3/25
 */

class LeetCode_892_Solution {

    public int surfaceArea(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                // 计算i,j位置上立方体的表面积
                res += grid[i][j] * 6 - Math.max((grid[i][j] - 1), 0) * 2;
                if (j > 0) // 计算列上的重叠面积
                    res -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                if (i > 0) // 计算行上的重叠面积
                    res -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
            }
        }
        return res;
    }

}

public class LeetCode_892_SurfaceAreaOf3DShapes {

    public static void main(String[] args) {
        LeetCode_892_Solution solution = new LeetCode_892_Solution();
        System.out.println(solution.surfaceArea(new int[][]{{2}}));
        System.out.println(solution.surfaceArea(new int[][]{{1, 2}, {3, 4}}));
    }

}
