package com.company.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 翻转字符串
 */
class LeetCode_151_Solution {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!"".equals(s1[i])) {
                sb.append(s1[i]).append(" ");
            }
        }
        String res = sb.toString();
        if ("".equals(res)) {
            return "";
        }
        return res.substring(0, res.length() - 1);
    }

    public String reverseWords11ms(String s) {
        String[] split = s.trim().split(" +");
        Collections.reverse(Arrays.asList(split));
        return String.join("", split);
    }

    /**
     * 定义一个List<String> 把字符串中的单词都拿出来之后倒序插入到StringBuilder中
     *
     * @param s
     * @return
     */
    public String reverseWords8ms(String s) {
        if (s == null) return null;
        List<StringBuilder> resArr = new ArrayList<>();
        for (int i = 0; i < s.length(); ) {
            while (i < s.length() && s.charAt(i) == ' ') {
                i++;
            }
            StringBuilder sb = new StringBuilder();
            while (i < s.length() && s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
                i++;
            }
            if (sb.length() > 0) {
                resArr.add(sb);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = resArr.size() - 1; i >= 0; i--) {
            sb.append(resArr.get(i));
            if (i > 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}

public class LeetCode_151_ReverseString {

    public static void main(String[] args) {
        LeetCode_151_Solution solution = new LeetCode_151_Solution();
        System.out.println("#" + solution.reverseWords("the sky is blue") + "#");
        System.out.println("#" + solution.reverseWords("  hello world! ") + "#");
        System.out.println("#" + solution.reverseWords("a good   example") + "#");
        System.out.println("#" + solution.reverseWords(" ") + "#");
    }

}
