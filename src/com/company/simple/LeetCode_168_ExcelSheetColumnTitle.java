package com.company.simple;

class LeetCode_168_Solution {

    private final static String TMP = "ZABCDEFGHIJKLMNOPQRSTUVWXY";

    public String convertToTitle(int n) {
        StringBuilder end = new StringBuilder();

        for (int i = n; i > 0; i = (i - 1) / 26) {
            end.insert(0, TMP.charAt(i % 26));
        }

        return end.toString();
    }
}

public class LeetCode_168_ExcelSheetColumnTitle {

    public static void main(String[] args) {
        LeetCode_168_Solution solution = new LeetCode_168_Solution();
        assert "A".equals(solution.convertToTitle(1));
        assert "AB".equals(solution.convertToTitle(28));
        assert "ZY".equals(solution.convertToTitle(701));
        System.out.println(solution.convertToTitle(26 * 26));
    }

}
