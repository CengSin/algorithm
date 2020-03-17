package com.company.simple;

/**
 * @description: 拼写单词
 * @author: 15262
 * @date: 2020/3/17
 */

class LeetCode_1160_Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charCnts = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            charCnts[chars.charAt(i) - 'a']++;
        }

        int len = 0;

        for (int i = 0; i < words.length; i++) {
            int[] wordsCnts = new int[26];
            boolean addStrLen = true;
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 'a';
                if (charCnts[index] == wordsCnts[index]) {
                    addStrLen = false;
                    break;
                }
                // chars中包含该字母,该字母可用
                wordsCnts[index] ++;
            }
            if (addStrLen) {
                len += words[i].length();
            }
        }

        return len;
    }
}

public class LeetCode_1160_FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        LeetCode_1160_Solution solution = new LeetCode_1160_Solution();
        System.out.println(solution.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(solution.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

}
