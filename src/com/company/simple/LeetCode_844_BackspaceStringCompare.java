package com.company.simple;

import java.util.Stack;

/**
 * @description: 比较含退格的字符串
 * @author: 15262
 * @date: 2020/3/6
 */
class LeetCode_844_Solution {


    /**
     * 使用双指针
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompareNew(String S, String T) {
        int i = S.length() - 1; // String s index
        int j = T.length() - 1; // String t index

        int backS = 0; // String s delete char numbers
        int backT = 0; // String t delete char numbers

        while (i >= 0 || j >= 0) {

            while (i >= 0) {
                if (S.charAt(i) == '#') {backS ++; i--;}
                else if (backS > 0) {backS --; i--;}
                else break;
            }

            while (j >= 0) {
                if (T.charAt(j) == '#') {backT ++; j--;}
                else if (backT > 0) {backT --; j--;}
                else break;
            }

            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;

            if (i >= 0 != j >= 0) return false;

            i--;
            j--;

        }

        return true;
    }

    /**
     * 使用栈
     * @param S
     * @param T
     * @return
     */
    public boolean backspaceCompare(String S, String T) {
        return simpleStr(S).equals(simpleStr(T));
    }

    private Stack<Character> simpleStr(String S) {
        Stack<Character> s1 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            s1.push(S.charAt(i));
            if (S.charAt(i) == '#') {
                if (!s1.empty()) s1.pop();
                if (!s1.empty()) s1.pop();
            }
        }
        return s1;
    }
}

public class LeetCode_844_BackspaceStringCompare {

    public static void main(String[] args) {
        LeetCode_844_Solution solution = new LeetCode_844_Solution();
        assert solution.backspaceCompareNew("ab#c", "ad#c");
        assert solution.backspaceCompareNew("ab##", "c#d#");
        assert solution.backspaceCompareNew("a##c", "#a#c");
        assert !solution.backspaceCompareNew("a#c", "b");
    }

}
