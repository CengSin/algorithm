package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 删除链表中的节点
 * @author: 15262
 * @date: 2020/3/28
 */

class LeetCode_237_Solution {

    public void deleteNode(ListNode node) {
        ListNode pre = node;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }

}

public class LeetCode_237_DeleteNodeLinkedList {

    public static void main(String[] args) {

    }

}
