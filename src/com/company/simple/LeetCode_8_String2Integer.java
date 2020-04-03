package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/3
 */

class LeetCode_8_Solution {

    public int myAtoi(String str) {
        char firstChar;
        if (str == null || (str = str.trim()).length() == 0 || (((firstChar = str.charAt(0)) != '+' && firstChar != '-') && firstChar < '0' || firstChar > '9'))
            return 0;

        int startIndex = 0;
        if (firstChar == '+' || firstChar == '-') {
            startIndex = 1;
        }
        long res = 0;
        for (int i = startIndex; i < str.length(); i++) {
            int num = str.charAt(i) - '0';
            if (num >= 0 && num <= 9) {
                res *= 10;
                res += num;
                if (res >= Integer.MAX_VALUE) {
                    if (firstChar == '+' || startIndex == 0) {
                        return Integer.MAX_VALUE;
                    } else {
                        return -res < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) -res;
                    }
                }
            } else {
                break;
            }
        }

        return (int) (firstChar == '-' ? -res : res);
    }
}

public class LeetCode_8_String2Integer {

    public static void main(String[] args) {
        LeetCode_8_Solution solution = new LeetCode_8_Solution();
        /*System.out.println(solution.myAtoi("42"));
        System.out.println(solution.myAtoi("   -42"));
        System.out.println(solution.myAtoi("4193 with words"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("-91283472332"));*/
        System.out.println(solution.myAtoi("2147483647"));
        System.out.println(solution.myAtoi("-2147483647"));
    }

}
