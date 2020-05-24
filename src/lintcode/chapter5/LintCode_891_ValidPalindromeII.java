package lintcode.chapter5;

class LintCode_891_Solution {
    /**
     * @param s: a string
     * @return boolean: whether you can make s a palindrome by deleting at most one character
     */
    public boolean validPalindrome(String s) {
        if (s == null || "".equals(s)) return true;
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
            ++start;
            --end;
        }
        return true;
    }

    private boolean isValid(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) != s.charAt(end)) return false;
        return isValid(s, ++start, --end);
    }
}

public class LintCode_891_ValidPalindromeII {
}
