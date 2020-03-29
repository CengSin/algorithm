package com.company.simple;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/29
 */

class LeetCode_706_MyHashMap {

    private int key;
    private int value;
    private LeetCode_706_MyHashMap left, right;

    /**
     * Initialize your data structure here.
     */
    public LeetCode_706_MyHashMap() {
    }

    public LeetCode_706_MyHashMap(int key, int value) {
        this.key = key;
        this.value = value;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        if (this.key > key) {
            if (this.left == null) {
                this.left = new LeetCode_706_MyHashMap(key, value);
            } else {
                this.left.put(key, value);
            }
        } else if (this.key < key) {
            if (this.right == null) {
                this.right = new LeetCode_706_MyHashMap(key, value);
            } else {
                this.right.put(key, value);
            }
        } else {
            this.value = value;
        }
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        if (this.key > key) {
            if (this.left == null) {
                return -1;
            } else {
                return this.left.get(key);
            }
        } else if (this.key < key) {
            if (this.right == null) {
                return -1;
            } else {
                return this.right.get(key);
            }
        } else {
            return this.value;
        }
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        if (this.key > key) {
            if (this.left != null) {
                this.left.remove(key);
            }
        } else if (this.key < key) {
            if (this.right != null) {
                this.right.remove(key);
            }
        } else {
            this.value = -1;
        }
    }
}

public class LeetCode_706_DesignHashMap {

    public static void main(String[] args) {
        LeetCode_706_MyHashMap hashMap = new LeetCode_706_MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(3));
        hashMap.put(2, 1); // 更新已有的值
        System.out.println(hashMap.get(2));
        hashMap.remove(2); // 删除键为2的数据
        System.out.println(hashMap.get(2));
    }

}
