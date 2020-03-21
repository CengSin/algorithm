package com.company.simple;

/**
 * @description: 水壶问题
 * @author: 15262
 * @date: 2020/3/21
 */

class LeetCode_365_Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        // 最后请用以上水壶中的一或两个来盛放取得的 z升 水。

        if (x == 0 || y == 0) {
            return y == z || x == z;
        }

        if (x + y < z) return false;

        // 使用x,y的最大公约数整除z，如果z可以被整除，返回true，否则返回false
        if (x < y) {
            int tmp  = x;
            x = y;
            y = tmp;
        }
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }

        return z % x == 0;
    }
}

public class LeetCode_365_WaterAndJugProblem {

    public static void main(String[] args) {
        LeetCode_365_Solution solution = new LeetCode_365_Solution();
        System.out.println(solution.canMeasureWater(3, 5, 4));
        System.out.println(solution.canMeasureWater(2, 6, 5));
        System.out.println(solution.canMeasureWater(34, 5, 6));
        System.out.println(solution.canMeasureWater(0, 0, 0));
        System.out.println(solution.canMeasureWater(0, 0, 1));
        System.out.println(solution.canMeasureWater(0, 2, 1));
    }

}
