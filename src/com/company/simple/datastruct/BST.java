package com.company.simple.datastruct;

/**
 * @description: 二叉搜索树
 * @author: 15262
 * @date: 2020/3/27
 */

public class BST {

    public static void main(String[] args) {
        BSTNode root = new BSTNode("a", "abc");
        root.put("b", "bcd");
        root.put("c", "cde");
        root.put("d", "dfe");
        root.put("e", "efg");
        System.out.println(root.get("e"));
    }

}
