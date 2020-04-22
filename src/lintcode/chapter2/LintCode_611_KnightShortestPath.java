package lintcode.chapter2;

import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}

class LintCode_611_Solution {

    private final int[][] move = {
            {1, 2},
            {1, -2},
            {-1, 2},
            {-1, -2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -1}
    };

    /**
     * @param grid:        a chessboard included 0 (false) and 1 (true)
     * @param source:      a point
     * @param destination: a point
     * @return: the shortest path
     */
    public int shortestPath(boolean[][] grid, Point source, Point destination) {
        // write your code here
        Queue<Point> queue = new LinkedList<>();
        queue.add(source);
        grid[source.x][source.y] = true;
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (point.x == destination.x && point.y == destination.y) return distance;
                for (int j = 0; j < move.length; j++) {
                    int newI = point.x + move[j][0];
                    int newJ = point.y + move[j][1];
                    Point newP = new Point(newI, newJ);
                    if (newI < 0 || newI >= grid.length || newJ < 0 || newJ >= grid[newI].length || grid[newI][newJ])
                        continue;
                    queue.offer(newP);
                    grid[newI][newJ] = true;
                }
            }
            distance++;
        }
        return -1;
    }
}

public class LintCode_611_KnightShortestPath {
}
