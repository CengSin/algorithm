package com.company.simple;

/**
 * @description: 颜色填充 dfs
 * @author: 15262
 * @date: 2020/3/15
 */

class LeetCode_08_10_Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        return getImages(image, sr, sc, newColor, image[sr][sc]);
    }

    private int[][] getImages(int[][] image, int sr, int sc, int newColor, int oldColor) {
        if (sr >= 0 && sc >= 0 && sr < image.length && sc < image[0].length && image[sr][sc] == oldColor && newColor != oldColor) {
            image[sr][sc] = newColor;

            getImages(image, sr - 1, sc, newColor, oldColor);
            getImages(image, sr + 1, sc, newColor, oldColor);
            getImages(image, sr, sc + 1, newColor, oldColor);
            getImages(image, sr, sc - 1, newColor, oldColor);
        }
        return image;
    }
}

public class LeetCode_08_10_ColorFillLCCI {

    public static void main(String[] args) {

        LeetCode_08_10_Solution solution = new LeetCode_08_10_Solution();
        /*int[][] images = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        solution.floodFill(images, 1, 1, 2);*/

        /*int[][] images1 = {
                {0, 0, 0},
                {0, 0, 0}
        };
        solution.floodFill(images1, 0, 0, 2);*/

        int[][] images1 = {
                {0, 0, 0},
                {0, 1, 1}
        };
        solution.floodFill(images1, 1, 1, 1);

        for (int i = 0; i < images1.length; i++) {
            for (int j = 0; j < images1[i].length; j++) {
                System.out.print(images1[i][j] + " ");
            }
            System.out.println();
        }
    }

}
