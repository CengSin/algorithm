package com.company.simple;

import java.util.Arrays;

/**
 * 无重复字符的最长子串
 */

class LeetCode_3_Solution {

    public int lengthOfLongestSubstring0MS(String s) {
        if (s == null)
            return 0;

        byte[] arrays = new byte[128];
        int n = s.length(), ans = 0, i = 0, j = 0, c;
        while (j < n) {
            c = s.charAt(j);
            if (i < arrays[c]) {
                if (ans < (byte)j - i)
                    ans = (byte)j - i;
                i = arrays[c];
            }
            arrays[c] = (byte) ++j;
        }
        if (ans < (byte)j - i)
            ans = (byte)j - i;
        return ans;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        int[] subStrArr = new int[127 - 32 + 1];
        int len = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int k = i;
            while (k < s.length()) {
                int index = s.charAt(k) - ' ';
                subStrArr[index] ++;
                if (subStrArr[index] > 1) {
                    Arrays.fill(subStrArr, 0);
                    break;
                }
                len++;
                k++;
            }
            if (len > max) max = len;
            len = 0;
        }

        return max;

    }

}

public class LeetCode_3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        LeetCode_3_Solution solution = new LeetCode_3_Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(" "));
        System.out.println(solution.lengthOfLongestSubstring(""));
        System.out.println(solution.lengthOfLongestSubstring(null));
        System.out.println(solution.lengthOfLongestSubstring("aab"));
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
    }

}
