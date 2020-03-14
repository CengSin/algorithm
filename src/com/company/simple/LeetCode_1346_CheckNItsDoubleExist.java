package com.company.simple;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。 && i < j
 * @author: 15262
 * @date: 2020/3/14
 */

class LeetCode_1346_Solution {

    public boolean checkIfExistSet(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) return true;
            set.add(arr[i] * 2);
            if (arr[i] % 2 == 0) set.add(arr[i] / 2);
        }

        return false;
    }

    public boolean checkIfExist(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                int tmp = arr[i] >> 1;
                for (int j = i + 1; (j % arr.length) != i; j++) {
                    if (arr[j % arr.length] == tmp) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

public class LeetCode_1346_CheckNItsDoubleExist {

    public static void main(String[] args) {
        LeetCode_1346_Solution solution = new LeetCode_1346_Solution();
        System.out.println(solution.checkIfExist(new int[]{10, 2, 5, 3}));
        System.out.println(solution.checkIfExist(new int[]{3, 1, 7, 11}));
    }

}
