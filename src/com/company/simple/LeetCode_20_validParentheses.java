package com.company.simple;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有效括号 github题解：https://leetcode-cn.com/problems/valid-parentheses/solution/
 * 括号类型为：() {} []
 */
public class LeetCode_20_validParentheses {

    public static void main(String[] args) {
        System.out.println(new Solution_20().isValid("["));
        System.out.println(new Solution_20().isValid("{[]}"));
        System.out.println(new Solution_20().isValid("]"));
        System.out.println(new Solution_20().isValid("()"));
        System.out.println(new Solution_20().isValid("()[]{}"));
        System.out.println(new Solution_20().isValid("(]"));
        System.out.println(new Solution_20().isValid("([)]"));
    }

}

class Solution_20 {

    private final String BRACKETS = "()[]{}";
    private final int[] BRACKETSPOWERS = {1, -1, 2, -2, 3, -3};

    public boolean isValid(String s) {
        List<Integer> powersForString = new ArrayList<>();
        for (int i = 0; i<s.length();i ++) {
            // 如果是正数则存入数组，如果是负数，则与数组最后一个数据相加，为零则删除数组最后一个数字，循环到字符串最后一个，否则输出false
            int number = BRACKETSPOWERS[BRACKETS.indexOf(s.charAt(i))];
            if (number > 0) {
                powersForString.add(number);
            } else if (powersForString.size()>0){
                int index = powersForString.size()-1;
                Integer temp = powersForString.get(index);
                if (temp + number != 0) {
                    return false;
                }
                powersForString.remove(index);
            } else {
                return false;
            }
        }
        return powersForString.isEmpty()?true:false;
    }
}