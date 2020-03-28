package com.company.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @description: 单词的压缩编码
 * @author: 15262
 * @date: 2020/3/28
 */

class LeetCode_820_TrieNode {

    char val;
    LeetCode_820_TrieNode[] childrens = new LeetCode_820_TrieNode[26];

    public LeetCode_820_TrieNode(char val) {
        this.val = val;
    }

    public LeetCode_820_TrieNode() {
    }
}

class LeetCode_820_Trie {
    LeetCode_820_TrieNode root;

    public LeetCode_820_Trie() {
        this.root = new LeetCode_820_TrieNode();
    }

    public int insert(String word) {
        LeetCode_820_TrieNode cur = root;
        boolean isNew = false;
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (cur.childrens[c] == null) {
                cur.childrens[c] = new LeetCode_820_TrieNode();
                isNew = true;
            }
            cur = cur.childrens[c];
        }
        return isNew ? word.length() + 1 : 0;
    }
}


class LeetCode_820_Solution {

    /**
     * 字典树解法
     * @param words
     * @return
     */
    public int trieSolution(String[] words) {
        if (words == null || words.length == 0) return 0;
        int len = 0;
        LeetCode_820_Trie root = new LeetCode_820_Trie();
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (int i = 0; i < words.length; i++) {
            len += root.insert(words[i]);
        }
        return len;
    }

    /**
     * 去重，并删除属于数组中某一字符串后缀的字符串，之后计算长度
     * @param words
     * @return
     */
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0) return 0;
        // 按照长度排序
        /*for (int j = 1; j < words.length; j++) {
            String key = words[j];
            int i = j - 1;
            while (i >= 0 && key.length() > words[i].length()) {
                words[i] = words[i + 1];
                i--;
            }
            words[i + 1] = key;
        }
        int minLen = words[0].length();
        for (int i = 1; i < words.length; i++) {
            if (!words[i - 1].endsWith(words[i])) {
                minLen += words[i].length() + 1;
            }
        }*/
        // 要和数组中每个字符进行比较，如果该字符串后缀子串已经在集合中出现，则从集合中删除掉该字符后缀
        Set<String> sets = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                sets.remove(word.substring(i));
            }
        }
        int minLen = 0;
        for (String set : sets) {
            minLen += set.length() + 1;
        }
        return minLen;
    }

}

public class LeetCode_820_ShortEncodingWords {

    public static void main(String[] args) {
        LeetCode_820_Solution solution = new LeetCode_820_Solution();
        System.out.println(solution.minimumLengthEncoding(new String[]{"time", "me", "bell"}));
        System.out.println(solution.minimumLengthEncoding(new String[]{"me", "time"}));
        System.out.println("================================================================");
        System.out.println(solution.trieSolution(new String[]{"time", "me", "bell"}));
        System.out.println(solution.trieSolution(new String[]{"me", "time"}));
    }

}
