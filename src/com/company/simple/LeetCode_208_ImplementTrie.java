package com.company.simple;

import com.company.simple.datastruct.Trie;

public class LeetCode_208_ImplementTrie {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        assert trie.search("apple");   // 返回 true
        assert !trie.search("app");     // 返回 false
        assert trie.startsWith("app"); // 返回 true
        trie.insert("app");
        assert trie.search("app");     // 返回 true
    }

}
