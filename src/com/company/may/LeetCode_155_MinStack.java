package com.company.may;

/**
 * 采用链表实现最小栈
 */
class Node {
    int val;
    int min;
    Node next;

    public Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

class MinStack {

    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }

    public void push(int x) {
        if (head == null) head = new Node(x, x, null);
        else head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

public class LeetCode_155_MinStack {
}
