package com.company.simple.datastruct;

/**
 * @description: notcallme
 * @author: 15262
 * @date: 2020/3/30
 */

public class AVLTree {

    public static void main(String[] args) {
        AVLTreeNode root = new AVLTreeNode("1", "abc");
        root = root.insert("2", "bcd")
        .insert("3", "cdf")
        .insert("4", "fgh");
        System.out.println(root.query("3"));
        root = root.delete("3");
        System.out.println(root.query("3"));
    }

}
