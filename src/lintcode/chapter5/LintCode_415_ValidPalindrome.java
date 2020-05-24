package lintcode.chapter5;

class LintCode_415_Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null || "".equals(s)) return true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            while (check(s.charAt(i)) && i < j) ++i;
            while (check(s.charAt(j)) && i < j) --j;
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    // 如果不是数字和字母，返回true
    private boolean check(char ch) {
        return !(ch >= '0' && ch <= '9') && !(ch >='A' && ch <= 'z');
    }
}

public class LintCode_415_ValidPalindrome {
}
