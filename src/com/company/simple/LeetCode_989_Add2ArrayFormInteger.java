package com.company.simple;

import java.util.*;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/3
 */

class LeetCode_989_Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        A[A.length - 1] += K;

        int num = 0;

        for (int i = A.length - 1; ; i--) {
            if (i >= 0) {
                num += A[i];
            }
            result.add(0, num % 10);
            num /= 10;
            if (num == 0 && i <= 0) {
                break;
            }
        }

        return result;
    }
}

public class LeetCode_989_Add2ArrayFormInteger {

    public static void main(String[] args) {
        LeetCode_989_Solution solution = new LeetCode_989_Solution();
        System.out.println(solution.addToArrayForm(new int[]{1, 2, 0, 0}, 34));
        System.out.println(solution.addToArrayForm(new int[]{1}, 9));
        System.out.println(solution.addToArrayForm(new int[]{1}, 999));
        System.out.println(solution.addToArrayForm(new int[]{1, 9, 9, 9}, 1));
        System.out.println(solution.addToArrayForm(new int[]{2, 4, 7}, 181));
        System.out.println(solution.addToArrayForm(new int[]{2, 1, 5}, 806));
        System.out.println(solution.addToArrayForm(new int[]{9,9,9,9,9,9,9,9,9,9}, 1));
    }

}
