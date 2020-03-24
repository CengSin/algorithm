package com.company.simple;

/**
 * @description: 一周中的第几天
 * @author: 15262
 * @date: 2020/3/24
 */

class LeetCode_1185_Solution {

    private final static String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    public String dayOfTheWeek(int day, int month, int year) {
        // 1971年1月1号是周五
        // 2100年12月31号也是周五
        // 基姆拉尔森计算公式 W= (d+2*m+3*(m+1)/5+y+y/4-y/100+y/400+1) mod 7
        // 如果是1月/2月，则要算作上一年的十三月和十四月
        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }

        return week[((day + 2 * month + 3 * (month + 1) / 5 + year + year / 4 - year / 100 + year / 400 + 1) % 7)];
    }
}

public class LeetCode_1185_DayofWeek {

    public static void main(String[] args) {
        LeetCode_1185_Solution solution = new LeetCode_1185_Solution();
        System.out.println(solution.dayOfTheWeek(1, 1, 1971));
    }

}
