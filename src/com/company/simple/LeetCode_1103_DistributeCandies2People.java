package com.company.simple;

import java.util.Arrays;

/**
 * @description: 分糖果2
 * @author: 15262
 * @date: 2020/3/5
 */

class LeetCode_1103_Solution {
    public int[] distributeCandies(int candies, int num_people) {
        if (num_people == 0) return null;

        int[] arr = new int[num_people];

        for (int i = 1; candies >= 0; i++) {

            arr[(i - 1) % num_people] += (Math.min(candies, i));
            candies -= i;

        }

        return arr;
    }
}

public class LeetCode_1103_DistributeCandies2People {

    public static void main(String[] args) {
        LeetCode_1103_Solution solution = new LeetCode_1103_Solution();
        System.out.println(Arrays.toString(solution.distributeCandies(7, 4)));
        System.out.println(Arrays.toString(solution.distributeCandies(10, 3)));
        System.out.println(Arrays.toString(solution.distributeCandies(10, 0)));
        System.out.println(Arrays.toString(solution.distributeCandies(0, 10)));
    }

}
