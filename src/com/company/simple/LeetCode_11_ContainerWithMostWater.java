package com.company.simple;

/**
 * 盛水最多的容器
 */

class LeetCode_11_Solution {

    public int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;
        while (i < j) {
            int h = Math.min(height[i], height[j]); // 寻找有效的高度
            maxArea = Math.max(maxArea, h * (j - i));
            if (height[i] < height[j]) i++; // 寻找更高的高度
            else j--;
        }
        return maxArea;
    }

    /**
     * O(n^2)的时间
     *
     * @param height
     * @return
     */
    private int timeSoLone(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int l = j - i;
                int w = Math.min(height[i], height[j]);
                max = Math.max(l * w, max);
            }
        }

        return max;
    }

}

public class LeetCode_11_ContainerWithMostWater {

    public static void main(String[] args) {
        LeetCode_11_Solution solution = new LeetCode_11_Solution();
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(solution.maxArea(new int[]{1, 2}));
    }

}
