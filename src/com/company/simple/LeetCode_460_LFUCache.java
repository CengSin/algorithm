package com.company.simple;

import com.company.simple.datastruct.LFUCache;

/**
 * @description: 最久最少被使用
 * @author: 15262
 * @date: 2020/4/5
 */

public class LeetCode_460_LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }

}
