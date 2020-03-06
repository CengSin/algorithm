package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/6
 */

class LeetCode_57_Solution {
    public int[][] findContinuousSequence(int target) {
        List<int[]> arr = new ArrayList<>();
        int l = 0;
        for (int i = 0; i < target / 2; i++) {
            int j = i + 1;
            int sum = 0;
            List<Integer> subSeq = new ArrayList<>();
            while (sum < target) {
                sum += j;
                subSeq.add(j);
                j++;
            }
            if (sum == target) {
                int[] ints = new int[subSeq.size()];
                for (int k = 0; k < subSeq.size(); k++) {
                    ints[k] = subSeq.get(k);
                }
                arr.add(ints);
                l++;
            }
        }

        int[][] res = new int[l][];
        for (int i = 0; i < l; i++) {
            res[i] = arr.get(i);
        }
        return res;
    }

}

public class LeetCode_57_LCOF {

    public static void main(String[] args) {
        LeetCode_57_Solution solution = new LeetCode_57_Solution();
        int[][] res = solution.findContinuousSequence(9);
        sout(res);
        res = solution.findContinuousSequence(15);
        sout(res);
    }

    private static void sout(int[][] res) {
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("========================");
    }

}
