package com.company.simple;

/**
 * @description: 字符串最大公因子
 * @author: 15262
 * @date: 2020/3/12
 */
class LeetCode_1071_Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1 != null && str2 != null && str1.length() > 0 && str2.length() > 0) {

            String longStr = str2;
            String shortStr = str1;
            if (str1.length() > str2.length()) {
                longStr = str1;
                shortStr = str2;
            }

            while (shortStr.length() > 0) {
                if (!longStr.contains(shortStr)) {
                    return "";
                }
                String tmp = longStr.replace(shortStr, "");
                longStr = shortStr;
                shortStr = tmp;
            }

            return longStr;
        }
        return "";
    }
}

public class LeetCode_1071_GreatestCommonDivisorStrings {

    public static void main(String[] args) {
        LeetCode_1071_Solution solution = new LeetCode_1071_Solution();
        System.out.println(solution.gcdOfStrings("ABCABC", "ABC"));
        System.out.println(solution.gcdOfStrings("ABAB", "AB"));
        System.out.println(solution.gcdOfStrings("leet", "code"));
        System.out.println(solution.gcdOfStrings("ABCDEF", "ABC"));
    }

}

