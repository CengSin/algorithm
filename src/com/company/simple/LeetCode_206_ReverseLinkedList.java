package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 翻转链表
 * @author: 15262
 * @date: 2020/3/2
 */

class LeetCode_206_Solution {

    /**
     * 双指针法，0ms，超越100%，内存使用 37.8mb 超越5.04%
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;

        ListNode cur = head, pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    /**
     * time 20ms 击败了7.52% 内存消耗 38.7mb 击败了5.04%
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode listNode = reverseList(head.next);
        ListNode tmp = listNode;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new ListNode(head.val);

        return listNode;
    }
}

public class LeetCode_206_ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        LeetCode_206_Solution solution = new LeetCode_206_Solution();
        ListNode reverseList = solution.reverseList1(head);
        while (reverseList != null) {
            System.out.print(reverseList.val + " ");
            reverseList = reverseList.next;
        }
        System.out.println();
    }

}
