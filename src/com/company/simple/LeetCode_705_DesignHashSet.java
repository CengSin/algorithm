package com.company.simple;

/**
 * @description: 涉及hash集合
 * @author: 15262
 * @date: 2020/3/29
 */

class MyHashSet {

    LeetCode_706_MyHashMap hashMap;

    /** Initialize your data structure here. */
    public MyHashSet() {
        hashMap = new LeetCode_706_MyHashMap(1000001, 0);
    }

    public void add(int key) {
        hashMap.put(key, 1);
    }

    public void remove(int key) {
        hashMap.remove(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashMap.get(key) != -1;
    }
}


public class LeetCode_705_DesignHashSet {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        assert hashSet.contains(1); // returns true
        assert !hashSet.contains(3); // returns false (not found)
        hashSet.add(2);
        assert hashSet.contains(2); // returns true
        hashSet.remove(2);
        assert !hashSet.contains(2); // returns false (already removed)
        System.out.println(hashSet.contains(0));
    }

}
