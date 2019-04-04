package com.company.simple;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *
 * 用时0ms的解法：
 * class Solution {
 *     public ListNode deleteDuplicates(ListNode head) {
 *         if (head == null || head.next == null) {
 *             return head;
 *         }
 *
 *         if (head.val != head.next.val) {
 *             head.next = deleteDuplicates(head.next);
 *             return head;
 *         } else {
 *             while ((head = head.next).next != null && (head.val == head.next.val)) {
 *             }
 *             return deleteDuplicates(head);
 *         }
 *     }
 * }
 */

class ListNode1 {
    int val;
    ListNode1 next;

    ListNode1(int x, ListNode1 next) {
        val = x;
        this.next = next;
    }
}

class Solution_83 {
    public ListNode1 deleteDuplicates(ListNode1 head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        }
        while ((head = head.next).next != null && head.val == head.next.val) {}
        return deleteDuplicates(head);
    }
}

public class LeetCode_83_RemoveDuplicatesfromSortedList {

    public static void main(String[] args) {
        ListNode1 head = new ListNode1(1, new ListNode1(1, new ListNode1(1, new ListNode1(1, null))));
        Solution_83 s = new Solution_83();
        head = s.deleteDuplicates(head);
        while (Objects.nonNull(head)) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }

}
