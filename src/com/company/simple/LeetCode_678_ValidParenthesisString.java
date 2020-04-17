package com.company.simple;

/**
 * 有效括号字符串
 */
class LeetCode_678_Solution {

    /**
     * 星号（*）可能同时表示左括号和右括号，所以从左到右遍历一遍是不可以包括所有情况的，所以需要从左到右遍历一遍（*为左括号），从右到左遍历一遍（*号为右括号）
     * left + right == 2*starNum
     *
     * @param s
     * @return
     */
    public boolean checkValidString(String s) {
        if (s.length() < 1) return true;
        int starNum = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') left--;
            else {
                left++;
                if (s.charAt(i) == '*') starNum++;
            }
            if (left < 0) return false;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') right--;
            else right++;
            if (right < 0) return false;
        }
        return right + left == 2 * starNum;
    }

}

public class LeetCode_678_ValidParenthesisString {

    public static void main(String[] args) {
        LeetCode_678_Solution solution = new LeetCode_678_Solution();
        System.out.println(solution.checkValidString("()"));
        System.out.println(solution.checkValidString("(*)"));
        System.out.println(solution.checkValidString("(*()"));
        System.out.println(solution.checkValidString("(*))"));
        System.out.println(solution.checkValidString(")("));
        System.out.println(solution.checkValidString("("));
        System.out.println(solution.checkValidString("(*()"));
        System.out.println(solution.checkValidString("(((******))"));
    }

}
