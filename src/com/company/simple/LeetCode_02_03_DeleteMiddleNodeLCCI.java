package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 删除链表的中间节点
 * @author: 15262
 * @date: 2020/3/27
 */
class LeetCode_02_03_Solution {
    public void deleteNode(ListNode node) {
        ListNode pre = null;
        while (node.next != null) {
            node.val = node.next.val;
            pre = node;
            node = node.next;
        }
        pre.next = null;
    }
}

public class LeetCode_02_03_DeleteMiddleNodeLCCI {

    public static void main(String[] args) {
        LeetCode_02_03_Solution solution = new LeetCode_02_03_Solution();
        ListNode first = new ListNode(4);
        ListNode node = new ListNode(5, new ListNode(1, new ListNode(9)));
        first.next = node;
        solution.deleteNode(node);
        while (first != null) {
            System.out.print(first.val + " ");
            first = first.next;
        }
    }

}
