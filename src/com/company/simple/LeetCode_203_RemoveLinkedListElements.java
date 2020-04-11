package com.company.simple;


import com.company.simple.datastruct.ListNode;

/**
 *
 * sql中id & 1可以判断奇数
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class LeetCode_203_Solution {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

}

public class LeetCode_203_RemoveLinkedListElements {

    public static void main(String[] args) {
        LeetCode_203_Solution solution = new LeetCode_203_Solution();
        ListNode listNode = solution.removeElements(new ListNode(1), 1);
    }

}
