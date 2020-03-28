package com.company.simple.datastruct;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/28
 */

public class Trie {
    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new TrieNode(c);
            }
            cur = cur.children[c];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int val = word.charAt(i) - 'a';
            if (cur.children[val] == null) {
                return false;
            }
            cur = cur.children[val];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int val = prefix.charAt(i) - 'a';
            if (cur.children[val] == null) {
                return false;
            }
            cur = cur.children[val];
        }
        return true;
    }
}
