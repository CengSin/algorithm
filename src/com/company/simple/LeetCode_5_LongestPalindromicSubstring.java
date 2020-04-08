package com.company.simple;

/**
 * 最长回文子串
 */

class LeetCode_5_Solution {

    public String longestPalindrome(String s) {
        // 如果S(i, j)是回文子串且s.char(i + 1) == s.char(j - 1)
        int len = s.length();
        if (len < 2) return s;
        boolean[][] resArr = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            resArr[i][i] = true;
        }
        int maxLen = 1;
        int startIndex = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j < 3) {
                        resArr[j][i] = true;
                    } else {
                        resArr[j][i] = resArr[j + 1][i - 1];
                    }
                } else {
                    resArr[j][i] = false;
                }
                if (resArr[j][i]) {
                    int curLen = i - j + 1;
                    if (curLen > maxLen) {
                        startIndex = j;
                        maxLen = curLen;
                    }
                }
            }

        }

        return s.substring(startIndex, startIndex + maxLen);
    }

}

public class LeetCode_5_LongestPalindromicSubstring {

    public static void main(String[] args) {
        LeetCode_5_Solution solution = new LeetCode_5_Solution();
        System.out.println(solution.longestPalindrome("babad"));
    }

}
