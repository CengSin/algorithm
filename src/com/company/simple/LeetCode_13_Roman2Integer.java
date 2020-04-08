package com.company.simple;

/**
 * 罗马数字转整数
 */

class LeetCode_13_SolutionNew {

    public int romanToInt(String s) {
        int num = 0;
        while (s.length() > 0) {
            if (s.startsWith("M")) {
                s = s.substring(1);
                num += 1000;
            } else if (s.startsWith("CM")) {
                s = s.substring(2);
                num += 900;
            } else if (s.startsWith("D")) {
                s = s.substring(1);
                num += 500;
            } else if (s.startsWith("CD")) {
                s = s.substring(2);
                num += 400;
            } else if (s.startsWith("C")) {
                s = s.substring(1);
                num += 100;
            } else if (s.startsWith("XC")) {
                s = s.substring(2);
                num += 90;
            } else if (s.startsWith("L")) {
                s = s.substring(1);
                num += 50;
            } else if (s.startsWith("XL")) {
                s = s.substring(2);
                num += 40;
            } else if (s.startsWith("X")) {
                s = s.substring(1);
                num += 10;
            } else if (s.startsWith("IX")) {
                s = s.substring(2);
                num += 9;
            } else if (s.startsWith("V")) {
                s = s.substring(1);
                num += 5;
            } else if (s.startsWith("IV")) {
                s = s.substring(2);
                num += 4;
            } else if (s.startsWith("I")) {
                s = s.substring(1);
                num += 1;
            }
        }
        return num;
    }


}

public class LeetCode_13_Roman2Integer {

    public static void main(String[] args) {
        LeetCode_13_SolutionNew solution = new LeetCode_13_SolutionNew();
        System.out.println(solution.romanToInt("III"));
        System.out.println(solution.romanToInt("IV"));
        System.out.println(solution.romanToInt("IX"));
        System.out.println(solution.romanToInt("LVIII"));
        System.out.println(solution.romanToInt("MCMXCIV"));
    }

}
