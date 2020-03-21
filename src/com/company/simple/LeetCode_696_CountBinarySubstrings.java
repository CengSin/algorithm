package com.company.simple;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 计算二进制子串
 * @author: 15262
 * @date: 2020/3/21
 */

class LeetCode_696_Solution {

    public int countBinarySubstringsNew(String s) {
        int cur = 0, pre = 0, ans = 0;
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j) == s.charAt(j - 1)) ++cur;
            else {
                pre = cur;
                cur = 0;
            }
            if (pre >= cur) ++ans;
        }
        return ans;
    }

    public int countBinarySubstrings(String s) {
        List<Integer> flags = new ArrayList<>();
        int ans = 0;

        for (int i = 0; i < s.length();) {
            // 计算连续0的长度
            ans = 0;
            while (i < s.length() && '0' == s.charAt(i)) {
                ans ++;
                i++;
            }
            flags.add(ans);
            // 计算连续1的长度
            ans = 0;
            while (i < s.length() && '1' == s.charAt(i)) {
                ans ++;
                i++;
            }
            flags.add(ans);
        }


        int sum = 0;
        for (int i = 1; i < flags.size(); i++) {
            sum += Math.min(flags.get(i), flags.get(i - 1));
        }

        return sum;
    }

}

public class LeetCode_696_CountBinarySubstrings {

    public static void main(String[] args) {
        LeetCode_696_Solution solution = new LeetCode_696_Solution();
        System.out.println(solution.countBinarySubstringsNew("00110011"));
        System.out.println(solution.countBinarySubstringsNew("10101"));
        System.out.println(solution.countBinarySubstringsNew("000111"));
        System.out.println(solution.countBinarySubstringsNew("11100"));
        System.out.println(solution.countBinarySubstringsNew("00011100"));
    }

}
