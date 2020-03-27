package com.company.simple.datastruct;

import java.util.Objects;

/**
 * @description: 二叉搜索树节点数据结构
 * @author: 15262
 * @date: 2020/3/27
 */

public class BSTNode {

    private String key;
    private Object value;
    private BSTNode left, right;

    public BSTNode(String key, Object value) {
        Objects.requireNonNull(key, "key值不能为空");
        this.key = key;
        this.value = value;
    }

    public void put(String key, Object value) {
        // 左小右大
        if (this.key.compareTo(key) < 0) {
            if (right == null) {
                right = new BSTNode(key, value);
            } else {
                right.put(key, value);
            }
        } else if (this.key.compareTo(key) > 0) {
            if (left == null) {
                left = new BSTNode(key, value);
            } else {
                left.put(key, value);
            }
        } else {
            this.value = value;
        }
    }

    public Object get(String key) {
        if (this.key.compareTo(key) < 0) {
            if (right == null) {
                return null;
            } else {
                return right.get(key);
            }
        } else if (this.key.compareTo(key) > 0) {
            if (left == null) {
                return null;
            } else {
                return left.get(key);
            }
        }
        return this.value;
    }

}
