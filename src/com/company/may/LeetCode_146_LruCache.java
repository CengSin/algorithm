package com.company.may;


import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 *
 *  LRU (最近最少使用) 缓存机制
 *
 *  get
 *  put
 *  O（1） 使用HashMap<key=>key,value=>value>
 */
class LeetCode_146_LRUCache {

    // 使用LinkedHaspMap保持插入顺序
    private Map<Integer, Integer> hashMap;
    private int capacity;

    public LeetCode_146_LRUCache(int capacity) {
        hashMap = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!hashMap.containsKey(key))
            return -1;
        // 把查询的值插入到map末尾，保证第一个值永远都是最近最少被使用的key
        Integer value = hashMap.get(key);
        hashMap.remove(key);
        hashMap.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (hashMap.containsKey(key))
            hashMap.remove(key);
        else if (hashMap.size() == capacity) {
            Iterator<Integer> iterator = hashMap.keySet().iterator();
            iterator.next();
            iterator.remove();
        }
        hashMap.put(key, value);
    }

}

public class LeetCode_146_LruCache {
}
