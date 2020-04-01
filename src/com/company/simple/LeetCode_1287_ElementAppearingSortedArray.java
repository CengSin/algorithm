package com.company.simple;

/**
 * @description: 有序数组中出现次数超过25%的元素
 * @author: 15262
 * @date: 2020/4/1
 */

class LeetCode_1287_Solution {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1) return arr[0];
        int len = 0;
        int num = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            num = arr[i];
            if (arr[i + 1] == arr[i]) {
                len++;
            } else {
                len = 0;
            }
            if (len >= (arr.length / 4)) break;
        }
        return num;
    }
}

public class LeetCode_1287_ElementAppearingSortedArray {

    public static void main(String[] args) {
        LeetCode_1287_Solution solution = new LeetCode_1287_Solution();
        System.out.println(solution.findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }

}
