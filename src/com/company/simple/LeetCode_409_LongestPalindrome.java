package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/19
 */
class LeetCode_409_Solution {

    /**
     * 只检查字符串中奇数个数的字母，之后用s.length - sum(奇数个数字母) + 1
     *
     * @param s
     * @return
     */
    public int longestPalindromeGreat(String s) {
        int sum = 0;
        int[] hash = new int[58];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < hash.length; i++) {
            sum += (hash[i] % 2);
        }
        return sum == 0 ? s.length() : (s.length() - sum + 1);
    }

    public int longestPalindrome(String s) {
        int sum = 0;
        int maxOdd = 0;
        int[] hash = new int[58];
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i) - 'A']++;
        }
        for (int i = 0; i < hash.length; i++) {
            if (hash[i] % 2 == 1) {
                maxOdd = 1;
                sum += hash[i] - 1;
            } else {
                sum += hash[i];
            }
        }
        return sum + maxOdd;
    }

}

public class LeetCode_409_LongestPalindrome {

    public static void main(String[] args) {
        LeetCode_409_Solution solution = new LeetCode_409_Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
        System.out.println(solution.longestPalindrome("bananas"));
        System.out.println(solution.longestPalindrome("bb"));
        System.out.println(solution.longestPalindrome("ABCDBCDA"));
        System.out.println(solution.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }

}
