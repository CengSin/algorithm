package com.company.simple;

/**
 * @description: 七进制
 * @author: 15262
 * @date: 2020/3/7
 */

class LeetCode_504_Solution {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        boolean isNega = false;
        if ((isNega = num < 0)) num = - num;
        StringBuilder s = new StringBuilder();
        for (int i = num; num != 0; num /= 7) {
            s.insert(0, (num % 7));
        }
        if (isNega) s.insert(0, "-");
        return s.toString();
    }
}

public class LeetCode_504_Base7 {

    public static void main(String[] args) {
        LeetCode_504_Solution solution = new LeetCode_504_Solution();
        System.out.println(solution.convertToBase7(100));
        System.out.println(solution.convertToBase7(-7));
        System.out.println(solution.convertToBase7(0));
        System.out.println(solution.convertToBase7(-8));
    }

}
