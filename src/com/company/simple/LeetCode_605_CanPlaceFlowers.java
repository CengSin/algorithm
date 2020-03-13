package com.company.simple;

/**
 * @description: 种花问题
 * @author: 15262
 * @date: 2020/3/13
 */

class LeetCode_605_Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                if (i == 0 && (flowerbed.length == 1 || flowerbed[i + 1] == 0)) {
                    n--;
                    flowerbed[i] = 1;
                } else if (i == flowerbed.length - 1 && flowerbed[i - 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }else if (i > 0 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0;
    }
}

public class LeetCode_605_CanPlaceFlowers {

    public static void main(String[] args) {
        LeetCode_605_Solution solution = new LeetCode_605_Solution();
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        System.out.println(solution.canPlaceFlowers(new int[]{0, 0, 0, 0, 1}, 2));
        System.out.println(solution.canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
    }

}
