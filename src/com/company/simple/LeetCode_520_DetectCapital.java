package com.company.simple;

/**
 * @description: 检测大写字母
 * @author: 15262
 * @date: 2020/3/30
 */
class LeetCode_520_Solution {

    // 全大写，全小写或者首字母大写都是true
    public boolean detectCapitalUse(String word) {
        char firstChar = word.charAt(0);
        boolean firstCharUpper = firstChar >= 'A' && firstChar <= 'Z';
        if (firstCharUpper) {
            // 如果首字母是大写，判断小写字母的数量是否为0 或者 小写字母的数量 + 1 == word的长度
            int lowerNumbers = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'a' && c <= 'z') lowerNumbers++;
            }
            return lowerNumbers == 0 || lowerNumbers == word.length() - 1;
        } else {
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c >= 'A' && c <= 'Z') return false;
            }
        }
        return true;
    }

}

public class LeetCode_520_DetectCapital {

    public static void main(String[] args) {
        LeetCode_520_Solution solution = new LeetCode_520_Solution();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
    }

}
