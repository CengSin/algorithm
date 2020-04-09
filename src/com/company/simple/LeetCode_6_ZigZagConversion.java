package com.company.simple;


import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 */

class LeetCode_6_Solution {

    public String convert(String s, int numRows) {

        if (numRows == 1) return s;
        int len = Math.min(s.length(), numRows);
        List<StringBuilder> resArr = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            resArr.add(new StringBuilder());
        }

        int row = 0;
        boolean up = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            resArr.get(row).append(c);
            if (row == 0 || row == numRows - 1) up = !up;
            row += up ? 1 : -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < resArr.size(); i++) {
            sb.append(resArr.get(i));
        }

        return sb.toString();
    }

}

public class LeetCode_6_ZigZagConversion {

    public static void main(String[] args) {
        LeetCode_6_Solution solution = new LeetCode_6_Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 3));
    }

}
