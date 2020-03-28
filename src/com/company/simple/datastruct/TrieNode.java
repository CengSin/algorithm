package com.company.simple.datastruct;

/**
 * @description: 前缀树实现（词典树）
 * @author: 15262
 * @date: 2020/3/28
 */

public class TrieNode {
    int val;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(int val) {
        this.val = val;
        initChildren();
    }

    public TrieNode() {
        initChildren();
    }

    private void initChildren() {
        this.children = new TrieNode[26];
    }
}
