package com.company.simple;

import java.util.Arrays;

/**
 * @description: 构造矩形
 * @author: 15262
 * @date: 2020/3/17
 */

class LeetCode_492_Solution {

    public int[] constructRectangleNew(int area) {
        int W = (int) Math.sqrt(area);
        while (area % W != 0) {
            W --;
        }
        return new int[]{area / W, W};
    }

    public int[] constructRectangle(int area) {
        int disparity = area - 1;
        int L = area;
        int W = 1;

        // L >= W 所以L为min(Li) W为max(Wi)
        int stride = 1;
        if (area % 2 != 0) {
            // 奇数的因数都是奇数
            stride = 2;
        }

        for (int i = 1; i <= area / 2; i += stride) {
            if (area % i == 0) {
                int tmp = area / i;
                if (tmp - i <= disparity && tmp - i >= 0) {
                    L = tmp;
                    W = i;
                    disparity = tmp - i;
                }
            }
        }

        return new int[]{L, W};
    }

}

public class LeetCode_492_ConstructRectangle {

    public static void main(String[] args) {
        LeetCode_492_Solution solution = new LeetCode_492_Solution();
        System.out.println(Arrays.toString(solution.constructRectangleNew(4)));
        System.out.println(Arrays.toString(solution.constructRectangleNew(5)));
        System.out.println(Arrays.toString(solution.constructRectangleNew(6)));
        System.out.println(Arrays.toString(solution.constructRectangleNew(7)));
    }

}
