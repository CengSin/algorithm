package com.company.simple;

import java.util.Arrays;
import java.util.List;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 示例 2：
 *
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 *
 * tips： 斐波那契数列
 */

class Solution_70 {

    /**
     * 缓存每次计算出来的值
     */
    public static final int[] arr = new int[1000];

    static {
        System.out.println(Arrays.toString(arr));
        arr[0] = 1;
        arr[1] = 1;
    }

    public int climbStairs(int n) {
        if (n < 2) {
            return 1;
        }
        else if (arr[n-1] == 0) {
            arr[n-1] = climbStairs(n-1);
            arr[n-2] = climbStairs(n-2);
        }
        return arr[n-1] + arr[n-2];
    }
}

public class LeetCode_70_ClimbingStairs {

    public static void main(String[] args) {
        Solution_70 s = new Solution_70();
        long startTime = System.currentTimeMillis();
        System.out.println("startTime="+startTime);
        System.out.println(s.climbStairs(44));
        System.out.println("running Time is " + (System.currentTimeMillis()-startTime));
        System.out.println(Arrays.toString(s.arr));
    }

}
