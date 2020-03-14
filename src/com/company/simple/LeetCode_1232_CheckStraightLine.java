package com.company.simple;

/**
 * @description: 缀点成线
 * @author: 15262
 * @date: 2020/3/14
 */

class LeetCode_1232_Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        // 斜率公式 (y1 - y0) / (x1 - x0) = (yi - y0) / (xi - x0)
        // 换成乘法 (y1 - y0) * (xi - x0) = (yi - y0) * (x1 - x0)
        for (int i = 3; i < coordinates.length; i++) {
            if ((coordinates[1][1] - coordinates[0][1]) * (coordinates[i][0] - coordinates[0][0]) != (coordinates[1][0] - coordinates[0][0]) * (coordinates[i][1] - coordinates[0][1])) {
                return false;
            }
        }
        return true;
    }
}

public class LeetCode_1232_CheckStraightLine {

    public static void main(String[] args) {

    }

}
