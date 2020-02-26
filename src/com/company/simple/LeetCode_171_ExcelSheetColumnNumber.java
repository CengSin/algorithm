package com.company.simple;

class LeetCode_171_Solution {
    public int titleToNumber(String s) {
        double sum = 0;

        int length = s.length();

        for (int i = length - 1; i >= 0; i--) {
            sum = sum + (s.charAt(i) - 'A' + 1) * Math.pow(26, length - 1 - i);
        }

        return (int) sum;
    }
}

public class LeetCode_171_ExcelSheetColumnNumber {

    public static void main(String[] args) {
        LeetCode_171_Solution solution = new LeetCode_171_Solution();
        System.out.println(solution.titleToNumber("ZY"));
        System.out.println(solution.titleToNumber("A"));
        System.out.println(solution.titleToNumber("B"));
        System.out.println(solution.titleToNumber("AA"));
        System.out.println(solution.titleToNumber("BB"));
        System.out.println(solution.titleToNumber("A0Y"));
    }

}
