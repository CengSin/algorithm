package com.company.simple;


import java.util.Arrays;

/**
 * 求两条直线的交点
 */

class Line {
    int[] start;
    int[] end;
    boolean isParallelY;
    boolean isParallelX;
    double k;  // 斜率
    double b; // 常数

    public Line(int[] start, int[] end) {
        this.start = start;
        this.end = end;
        this.k = (this.end[1] - this.start[1]) * 1.0 / (this.end[0] - this.start[0]);
        this.b = this.start[1] - this.k * this.start[0];
        // 判断是否存在于y轴平行的线段
        this.isParallelY = (this.k == Double.POSITIVE_INFINITY || this.k == Double.NEGATIVE_INFINITY);
        this.isParallelX = this.k == 0;
    }

    public double[] intersection(Line l1) {
        // 只判断相交的情况
        if (this.isParallelY && !l1.isParallelY) {
            double x = this.start[0];
            double y = l1.k * x + l1.b;
            return new double[]{x, y};
        } else if (l1.isParallelY && !this.isParallelY) {
            double x = l1.start[0];
            double y = this.k * x + this.b;
            return new double[]{x, y};
        } else if (this.isParallelX && !l1.isParallelX) {
            double y = this.start[1];
            double x = (y - l1.b) / l1.k;
            return new double[]{x, y};
        } else if (!this.isParallelX && l1.isParallelX) {
            double y = l1.start[1];
            double x = (y - this.b) / this.k;
            return new double[]{x, y};
        } else if (this.k == l1.k && (this.start[0] == l1.start[0] || this.start[1] == l1.start[1])) {  // 平行且重叠
            // todo 判断平行且重叠部分的最小值
        } else {
            // 当两条直线都不平行于x,也不平行于y
            double x = (l1.b - this.b) / (this.k - l1.k);
            double y = Math.min(this.k * x + this.b, l1.k * x + l1.b);
            return new double[]{x, y};
        }
        return new double[]{};
    }
}

class LeetCode_16_03_LCOF_Solution_Copy {
    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {
        int x1 = start1[0], y1 = start1[1];
        int x2 = end1[0], y2 = end1[1];
        int x3 = start2[0], y3 = start2[1];
        int x4 = end2[0], y4 = end2[1];

        double[] ans = new double[2];
        Arrays.fill(ans, Double.MAX_VALUE);
        // 判断两直线是否平行
        if ((y4-y3)*(x2-x1) == (y2-y1)*(x4-x3)) {
            // 判断两直线是否重叠
            if ((y2-y1)*(x3-x1) == (y3-y1)*(x2-x1)) {
                // 判断 (x3, y3) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x3, y3)) {
                    updateRes(ans, x3, y3);
                }
                // 判断 (x4, y4) 是否在「线段」(x1, y1)~(x2, y2) 上
                if (isInside(x1, y1, x2, y2, x4, y4)) {
                    updateRes(ans, (double)x4, (double)y4);
                }
                // 判断 (x1, y1) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x1, y1)) {
                    updateRes(ans, (double)x1, (double)y1);
                }
                // 判断 (x2, y2) 是否在「线段」(x3, y3)~(x4, y4) 上
                if (isInside(x3, y3, x4, y4, x2, y2)) {
                    updateRes(ans, (double)x2, (double)y2);
                }
            }
        } else {
            // 联立方程得到 t1 和 t2 的值
            double t1 = (double)(x3 * (y4 - y3) + y1 * (x4 - x3) - y3 * (x4 - x3) - x1 * (y4 - y3)) / ((x2 - x1) * (y4 - y3) - (x4 - x3) * (y2 - y1));
            double t2 = (double)(x1 * (y2 - y1) + y3 * (x2 - x1) - y1 * (x2 - x1) - x3 * (y2 - y1)) / ((x4 - x3) * (y2 - y1) - (x2 - x1) * (y4 - y3));
            // 判断 t1 和 t2 是否均在 [0, 1] 之间
            if (t1 >= 0.0 && t1 <= 1.0 && t2 >= 0.0 && t2 <= 1.0) {
                ans[0] = x1 + t1 * (x2 - x1);
                ans[1] = y1 + t1 * (y2 - y1);
            }
        }
        if (ans[0] == Double.MAX_VALUE) {
            return new double[0];
        }
        return ans;
    }

    // 判断 (x, y) 是否在「线段」(x1, y1)~(x2, y2) 上
    // 这里的前提是 (x, y) 一定在「直线」(x1, y1)~(x2, y2) 上
    private boolean isInside(int x1, int y1, int x2, int y2, int x, int y) {
        // 若与 x 轴平行，只需要判断 x 的部分
        // 若与 y 轴平行，只需要判断 y 的部分
        // 若为普通线段，则都要判断
        return (x1 == x2 || (Math.min(x1, x2) <= x && x <= Math.max(x1, x2)))
                && (y1 == y2 || (Math.min(y1, y2) <= y && y <= Math.max(y1, y2)));
    }

    private void updateRes(double[] ans, double x, double y) {
        if (x < ans[0] || (x == ans[0] && y < ans[1])) {
            ans[0] = x;
            ans[1] = y;
        }
    }
}

class LeetCode_16_03_LCOF_Solution_ZZT {

    public double[] intersection(int[] start1, int[] end1, int[] start2, int[] end2) {

        Line line1 = new Line(start1, end1);
        Line line2 = new Line(start2, end2);

        double[] point = line1.intersection(line2);

        // 判断交点是否同时在两条线段上即可
        if (point.length > 0 && isExist(start1, end1, point) && isExist(start2, end2, point)) {
            return point;
        } else {
            return new double[]{};
        }
    }

    private boolean isExist(int[] start1, int[] end1, double[] point) {
        return (start1[0] <= point[0] && point[0] <= end1[0]) || (point[0] >= end1[0] || point[0] <= start1[0]);
    }

}

public class LeetCode_16_03_LCOF {

    public static void main(String[] args) {
        LeetCode_16_03_LCOF_Solution_ZZT leetCode1603LCOFSolutionZZT = new LeetCode_16_03_LCOF_Solution_ZZT();
        System.out.println(Arrays.toString(leetCode1603LCOFSolutionZZT.intersection(new int[]{0, 0}, new int[]{1, 0}, new int[]{1, 1}, new int[]{0, -1})));
        System.out.println(Arrays.toString(leetCode1603LCOFSolutionZZT.intersection(new int[]{0, 3}, new int[]{0, 6}, new int[]{0, 1}, new int[]{0, 5})));
        System.out.println(Arrays.toString(leetCode1603LCOFSolutionZZT.intersection(new int[]{0, 0}, new int[]{0, 1}, new int[]{1, 0}, new int[]{1, 1})));
        System.out.println(Arrays.toString(leetCode1603LCOFSolutionZZT.intersection(new int[]{0, 0}, new int[]{0, 1}, new int[]{0, 0}, new int[]{0, -1})));
    }

}
