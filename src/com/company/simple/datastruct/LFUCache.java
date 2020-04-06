package com.company.simple.datastruct;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/4/5
 */

class LFUCacheNode {
    int key;
    int value;
    int freq;
    LFUCacheNode pre, post;

    public LFUCacheNode() {
    }

    public LFUCacheNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

public class LFUCache {

    Map<Integer, LFUCacheNode> cache;
    int capacity;
    int size;
    LFUCacheNode head, tail;

    public LFUCache(int capacity) {
        head = new LFUCacheNode();
        tail = new LFUCacheNode();
        head.post = tail;
        tail.pre = head;
        cache = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if (capacity > 0 && cache.containsKey(key)) {
            LFUCacheNode LFUCacheNode = cache.get(key);
            LFUCacheNode.freq++;
            move2NewPosition(LFUCacheNode);
            return LFUCacheNode.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        LFUCacheNode LFUCacheNode = cache.get(key);
        if (LFUCacheNode != null) {
            LFUCacheNode.value = value;
            LFUCacheNode.freq++;
            move2NewPosition(LFUCacheNode);
        } else {
            if (size == capacity) {
                cache.remove(head.post.key);
                removeNode(head.post);
                size--;
            }
            LFUCacheNode newLFUCacheNode = new LFUCacheNode(key, value);
            addNode(newLFUCacheNode);
            cache.put(key, newLFUCacheNode);
            size++;
        }
    }

    private void move2NewPosition(LFUCacheNode LFUCacheNode) {
        LFUCacheNode nextLFUCacheNode = LFUCacheNode.post;
        removeNode(LFUCacheNode);
        while (nextLFUCacheNode.freq <= LFUCacheNode.freq && nextLFUCacheNode != tail) {
            nextLFUCacheNode = nextLFUCacheNode.post;
        }
        nextLFUCacheNode.pre.post = LFUCacheNode;
        LFUCacheNode.pre = nextLFUCacheNode.pre;
        LFUCacheNode.post = nextLFUCacheNode;
        nextLFUCacheNode.pre = LFUCacheNode;
    }

    private void addNode(LFUCacheNode LFUCacheNode) {
        LFUCacheNode.post = head.post;
        LFUCacheNode.pre = head;
        head.post.pre = LFUCacheNode;
        head.post = LFUCacheNode;
        move2NewPosition(LFUCacheNode);
    }

    private void removeNode(LFUCacheNode LFUCacheNode) {
        LFUCacheNode.pre.post = LFUCacheNode.post;
        LFUCacheNode.post.pre = LFUCacheNode.pre;
    }
}