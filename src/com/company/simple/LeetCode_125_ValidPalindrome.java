package com.company.simple;

/**
 * 验证回文串，只考虑数字和字母，回文串就是真虚和反序相同的字符串
 */
class LeetCode_125_Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.toLowerCase().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if ((str[i] >= '0' && str[i] <= '9') || (str[i] >= 'a' && str[i] <= 'z')) {
                sb.append(str[i]);
            }
        }
        return isPalindromeStr(sb.toString());
    }

    private boolean isPalindromeStr(String s) {
        if (s.length() <= 1) return true;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}

public class LeetCode_125_ValidPalindrome {
    public static void main(String[] args) {
        LeetCode_125_Solution soltion = new LeetCode_125_Solution();
        System.out.println(soltion.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(soltion.isPalindrome("0P"));
        assert soltion.isPalindrome("`l;`` 1o1 ??;l`");
    }
}
