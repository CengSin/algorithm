package com.company.simple;

/**
 * @description: 矩形重叠
 * @author: 15262
 * @date: 2020/3/18
 */
class LeetCode_836_Solution {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return (rec1[2] > rec2[0]) && (rec1[3] > rec2[1]) && ((rec1[0] <= rec2[0]) || (rec1[1] <= rec2[1]));
    }

}

public class LeetCode_836_RectangleOverlap {

    public static void main(String[] args) {
        LeetCode_836_Solution solution = new LeetCode_836_Solution();
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(solution.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
        System.out.println(solution.isRectangleOverlap(new int[]{5, 15, 8, 18}, new int[]{0, 3, 7, 9}));
        System.out.println(solution.isRectangleOverlap(new int[]{2, 17, 6, 20}, new int[]{3, 8, 6, 20}));
    }

}
