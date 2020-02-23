package com.company.simple;


import java.util.Objects;

/**
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 *
 * 如果不存在最后一个单词，请返回 0 。
 *
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 *
 * 示例:
 *
 * 输入: "Hello World"
 * 输出: 5
 */

public class LeetCode_58_Solution {

    public int lengthOfLastWord(String s) {
        int result = 0;
        if (Objects.nonNull(s)) {
            s = s.trim();
            int strLength = s.length();
            if (strLength != 0 && s.charAt(strLength-1) != ' ') {
                String[] split = s.split(" ");
                int arrLength = split.length;
                result = split[arrLength - 1].length();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LeetCode_58_Solution s = new LeetCode_58_Solution();
        System.out.println(s.lengthOfLastWord(" "));
        System.out.println(s.lengthOfLastWord(" Hello World"));
        System.out.println(s.lengthOfLastWord(null));
    }

}
