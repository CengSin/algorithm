package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 链表的中间节点
 * @author: 15262
 * @date: 2020/3/23
 */

class LeetCode_876_Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null) return null;
        int cnt = 0;
        ListNode first = head;
        while (head != null) {
            cnt ++;
            head = head.next;
        }

        int mid = cnt / 2;
        int count = 0;
        while (count != mid) {
            first = first.next;
            count ++;
        }
        return first;
    }
}

public class LeetCode_876_MiddleOfLinkedList {

    public static void main(String[] args) {
        LeetCode_876_Solution solution = new LeetCode_876_Solution();
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ListNode middle = solution.middleNode(listNode);
        while (middle != null) {
            System.out.println(middle.val);
            middle = middle.next;
        }
    }

}
