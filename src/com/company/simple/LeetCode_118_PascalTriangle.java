package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * 杨辉三角形
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */

class LeetCode_118_Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> array = new ArrayList<>(numRows);
        if (numRows <= 0) {
            return array;
        }
        // a[m][n] = a[m-1][n-1] + a[m-1][n+1]
        for (int j = 0; j < numRows; j++) {
            List<Integer> row = new ArrayList<>();
            for (int i = 0; i < j + 1; i++) {
                row.add(1);
            }
            if (j > 1) {
                for (int i = 0; i < j + 1; i++) {
                    if (i > 0 && i < j) {
                        row.add(i, array.get(j - 1).get(i - 1) + array.get(j - 1).get(i));
                    }
                }
            }
            array.add(j, row.subList(0, j+1));
        }
        return array;
    }
}

public class LeetCode_118_PascalTriangle {

    public static void main(String[] args) {
        LeetCode_118_Solution solution = new LeetCode_118_Solution();
        List<List<Integer>> generate = solution.generate(6);
        for (List<Integer> row : generate) {
            System.out.println(row);
        }
    }

}
