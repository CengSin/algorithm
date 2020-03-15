package com.company.simple;

/**
 * @description: 字符重排
 * @author: 15262
 * @date: 2020/3/15
 */

class LeetCode_01_02_Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] s1Char = new int[26]; // 表示字母i的出现个数s1Char[i]
        int[] s2Char = new int[26]; // 表示字母i的出现个数s2Char[i]
        getStrCharNum(s1, s1Char);
        getStrCharNum(s2, s2Char);

        for (int i = 0; i < 26; i++) {
            if (s1Char[i] != s2Char[i]) {
                return false;
            }
        }

        return true;
    }

    private void getStrCharNum(String s1, int[] s1Char) {
        for (int i = 0; i < s1.length(); i++) {
            s1Char[s1.charAt(i) - 'a']++;
        }
    }
}

public class LeetCode_01_02_CheckPermutationLCCI {

    public static void main(String[] args) {
        LeetCode_01_02_Solution solution = new LeetCode_01_02_Solution();
        System.out.println(solution.CheckPermutation("abc", "bca"));
        System.out.println(solution.CheckPermutation("abc", "bad"));
    }

}

