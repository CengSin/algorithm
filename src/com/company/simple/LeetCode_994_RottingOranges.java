package com.company.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/4
 */

class Orange {
    int i;
    int j;
    int minutes;
}

class LeetCode_994_Solution {

    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<Orange> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    Orange orange = new Orange();
                    orange.i = i;
                    orange.j = j;
                    orange.minutes = minutes;
                    queue.offer(orange);
                }
            }
        }

        while (queue.size() > 0) {
            Orange poll = queue.poll();

            int x = poll.i, y = poll.j;
            minutes = poll.minutes;

            if (x - 1 >= 0 && grid[x - 1][y] == 1) {
                Orange orange = new Orange();
                orange.i = x - 1;
                orange.j = y;
                orange.minutes = minutes + 1;
                queue.offer(orange);
                grid[x - 1][y] = 2;
            }
            if (x + 1 < grid.length && grid[x + 1][y] == 1) {
                Orange orange = new Orange();
                orange.i = x + 1;
                orange.j = y;
                orange.minutes = minutes + 1;
                queue.offer(orange);
                grid[x + 1][y] = 2;
            }
            if (y - 1 >= 0 && grid[x][y - 1] == 1) {
                Orange orange = new Orange();
                orange.i = x;
                orange.j = y - 1;
                orange.minutes = minutes + 1;
                queue.offer(orange);
                grid[x][y - 1] = 2;
            }
            if (y + 1 < grid[0].length && grid[x][y + 1] == 1) {
                Orange orange = new Orange();
                orange.i = x;
                orange.j = y + 1;
                orange.minutes = minutes + 1;
                queue.offer(orange);
                grid[x][y + 1] = 2;
            }

        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return minutes;
    }

}

public class LeetCode_994_RottingOranges {

    public static void main(String[] args) {
        LeetCode_994_Solution solution = new LeetCode_994_Solution();
        int[][] mockData1 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("mockData1 = " + solution.orangesRotting(mockData1));

        int[][] mockData2 = {
                {2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}
        };
        System.out.println("mockData2 = " + solution.orangesRotting(mockData2));

        int[][] mockData3 = {{0, 2}};

        System.out.println("mockData3 = " + solution.orangesRotting(mockData3));

        int[][] mockData4 = {{1, 1, 2, 0, 2, 0}};

        System.out.println("mockData4 = " + solution.orangesRotting(mockData4));

        int[][] mockData5 = {{2, 0, 1, 2, 1, 2}};

        System.out.println("mockData5 = " + solution.orangesRotting(mockData5));
    }

}
