package com.company.simple;

import java.util.*;

/**
 * @author zhangzetao
 */

class LeetCode_119_Solution {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            return arr;
        }

        if (rowIndex == 1) {
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(1);
            arr.add(1);
            return arr;
        }

        return transf(getRow(rowIndex - 1), rowIndex);
    }

    public List<Integer> transf(List<Integer> arr, int rowIndex) {
        Integer[] result = new Integer[rowIndex + 1];
        result[0] = 1;
        result[rowIndex] = 1;
        // 从头开始会导致之前计算出来的结果影响后面的结果
        // 从后开始arr自动把结算的结果插入到list中，之后的数字自动右移，导致结果错误
        // a[m][n] = a[m-1][n-1] + a[m-1][n]
        for (int i = rowIndex - 1; i > 0; i--) {
            result[i] = arr.get(i) + arr.get(i - 1);
        }
        return Arrays.asList(result);
    }
}

public class LeetCode_119_PascalTriangleII {

    public static void main(String[] args) {
        LeetCode_119_Solution sol = new LeetCode_119_Solution();
        List<Integer> row = sol.getRow(5);
        System.out.println(row);
    }

}
