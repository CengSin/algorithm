package lintcode.chapter1;

import java.util.HashMap;
import java.util.Set;

/**
 * 最长回文串
 */
class LintCode_627_Solution {
    /**
     * @param s: a string which consists of lowercase or uppercase letters
     * @return: the length of the longest palindromes that can be built
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!hashMap.containsKey(s.charAt(i))) {
                hashMap.put(s.charAt(i), 0);
            }
            hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
        }

        int sum = 0;
        int oddNUmber = 0;
        Set<Character> keys = hashMap.keySet();
        for (Character key : keys) {
            Integer number = hashMap.get(key);
            if (number % 2 != 0) {
                sum += (number - 1);
                oddNUmber ++;
            } else {
                sum += number;
            }
        }

        if (oddNUmber > 0) {
            return sum + 1;
        } else {
            return sum;
        }
    }
}

public class LintCode_627_LongestPalindrome {

    public static void main(String[] args) {
        LintCode_627_Solution solution = new LintCode_627_Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }

}
