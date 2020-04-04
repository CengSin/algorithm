package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/4
 */

class LeetCode_1394_Solution {

    public int findLucky(int[] arr) {
        int[] res = new int[501];
        for (int i = 0; i < arr.length; i++) {
            res[arr[i]]++;
        }
        for (int i = res.length - 1; i >= 1; i--) {
            if (i == res[i]) return i;
        }
        return -1;
    }

}

public class LeetCode_1394_FindLuckyIntegerArray {

    public static void main(String[] args) {
        LeetCode_1394_Solution solution = new LeetCode_1394_Solution();
        System.out.println(solution.findLucky(new int[]{2, 2, 3, 4}));
        System.out.println(solution.findLucky(new int[]{2, 2, 2, 3}));
    }

}
