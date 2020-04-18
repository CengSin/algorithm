package com.company.simple;

import java.util.Arrays;

class LeetCode_758_Solution {

    public String boldWords(String[] words, String S) {
        int[] mask = new int[S.length()];
        int startIndex = 0;
        for (String word : words) {
            if (S.contains(word)) {
                int index = S.indexOf(word, startIndex);
                if (index >= 0) {
                    Arrays.fill(mask, index, index + word.length(), 1);
                }
                startIndex = index + word.length() - 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mask.length; i++) {
            if (mask[i] != 1) {
                sb.append(S.charAt(i));
            } else {
                sb.append("<b>");
                while (mask[i] == 1 && i < mask.length) {
                    sb.append(S.charAt(i));
                    i++;
                }
                sb.append("</b>");
                i --;
            }
        }
        return sb.toString();
    }

}

public class LeetCode_758_BoldWordsInString {

    public static void main(String[] args) {
        LeetCode_758_Solution solution = new LeetCode_758_Solution();
        System.out.println(solution.boldWords(new String[]{"ab", "bc"}, "aabcd"));
    }

}
