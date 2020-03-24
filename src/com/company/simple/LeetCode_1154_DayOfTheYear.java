package com.company.simple;

/**
 * @description: 一年中的第几天
 * @author: 15262
 * @date: 2020/3/24
 */

class LeetCode_1154_Solution {

    private final static int[] daysOfMouth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int dayOfYear(String date) {
        String[] times = date.split("-");
        int days = Integer.parseInt(times[2]);
        if ("01".equals(times[1])) return days;
        int mouth = Integer.parseInt(times[1]) - 1;
        for (int i = 0; i < mouth; i++) {
            days += daysOfMouth[i];
        }
        int year = Integer.parseInt(times[0]);
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) && (mouth > 1) ? days + 1 : days;
    }

}

public class LeetCode_1154_DayOfTheYear {

    public static void main(String[] args) {
        LeetCode_1154_Solution solution = new LeetCode_1154_Solution();
        System.out.println(solution.dayOfYear("2019-01-09"));
        System.out.println(solution.dayOfYear("2019-02-10"));
        System.out.println(solution.dayOfYear("2003-03-01"));
        System.out.println(solution.dayOfYear("2004-03-01"));
        System.out.println(solution.dayOfYear("2016-02-29"));
        System.out.println(solution.dayOfYear("2012-02-04"));
    }

}
