package lintcode.chapter1;

/**
 * 背向双指针 + 回文串的特性（如果s[i + 1, j-1]是回文串且s[i] == s[j], 则s[i, j]也是回文串）
 * 最长回文串
 */
class LintCode_200_Solution {

    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 1) return s;

        int len = 0, start = 0, longest = 0;
        for (int i = 0; i < s.length(); i++) {
            len = isPalindrome(s, i, i + 1);

            if (len > longest) {
                longest = len;
                start = i - len / 2 + 1;
            }

            len = isPalindrome(s, i, i);

            if (len > longest) {
                longest = len;
                start = i - len / 2;
            }
        }

        return s.substring(start, start + longest);
    }

    /**
     * 背向双指针
     * @param s
     * @param mid
     * @param mid1
     * @return
     */
    private int isPalindrome(String s, int mid, int mid1) {
        int len = 0;
        int i = mid;
        int j = mid1;
        while (i >= 0 && j < s.length()) {
            if (s.charAt(i) != s.charAt(j)) break;
            len += (i == j ? 1 : 2);
            i--;
            j++;
        }
        return len;
    }

}

public class LintCode_200_longestPalindromicSubstring {

    public static void main(String[] args) {
        LintCode_200_Solution solution = new LintCode_200_Solution();
        System.out.println(solution.longestPalindrome("abcdzdcab"));
        System.out.println(solution.longestPalindrome("abcde"));
        System.out.println(solution.longestPalindrome("bb"));
    }

}
