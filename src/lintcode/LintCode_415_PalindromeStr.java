package lintcode;

class LintCode_415_Solution_New {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        // write your code here
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < s.length() && !checkIsNumberOrCharactor(s.charAt(i))) {
                i++;
            }
            if (i == s.length()) {return true;}
            while (j >= 0 && !checkIsNumberOrCharactor(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i = i + 1;
            j = j - 1;
        }
        return true;
    }

    private boolean checkIsNumberOrCharactor(char charAt) {
        return ('0' <= charAt && charAt <= '9') || ('a' <= charAt && charAt <= 'z') || ('A' <= charAt && charAt <= 'Z');
    }
}

class LintCode_415_Solution {
    /**
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (checkIsNumberOrCharactor(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        if (sb.length() < 2) return true;
        // write your code here
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            if (!(sb.charAt(i) + "").equalsIgnoreCase(sb.charAt(j) + "")) {
                return false;
            }
            i = i + 1;
            j = j - 1;
        }
        return true;
    }

    private boolean checkIsNumberOrCharactor(char charAt) {
        return ('0' <= charAt && charAt <= '9') || ('a' <= charAt && charAt <= 'z') || ('A' <= charAt && charAt <= 'Z');
    }
}

public class LintCode_415_PalindromeStr {

    public static void main(String[] args) {
        LintCode_415_Solution solution = new LintCode_415_Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.isPalindrome(".,"));
    }

}
