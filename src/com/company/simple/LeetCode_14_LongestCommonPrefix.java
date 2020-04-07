package com.company.simple;

/**
 * 最长公共前缀
 */
class Solution_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0 || strs[0].length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            sb.append(strs[0].charAt(i));
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(sb.toString())) {
                    return sb.substring(0, sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

}

public class LeetCode_14_LongestCommonPrefix {

    public static void main(String[] args) {
        Solution_14 solution_14 =new Solution_14();
        System.out.println(solution_14.longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }

}
