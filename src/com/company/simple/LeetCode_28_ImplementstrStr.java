package com.company.simple;

import java.util.Objects;

class Solution_28 {

    /**
     * @date 2018/12/13 21:00
     *
     * @return int
     * @description
     * @throws
    */
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.equals("")){
            return 0;
        }
        for (int i = 0; i<haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)
                    && haystack.length() - i >= needle.length()
                    && haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}

public class LeetCode_28_ImplementstrStr {

    public static void main(String[] args) {
        Solution_28 solution_28 = new Solution_28();
        System.out.println(solution_28.strStr("hello", "ll"));

    }

}
