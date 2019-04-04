package com.company.simple;

/**
 * Definition for singly-linked list.
 * public class ListNode_21 {
 *     int val;
 *     ListNode_21 next;
 *     ListNode_21(int x) { val = x; }
 * }
 */

class ListNode_21 {
    int val;
    ListNode_21 next;

    public ListNode_21(int x) {
        this.val = x;
    }
}

class Solution_21 {
    public ListNode_21 mergeTwoLists(ListNode_21 l1, ListNode_21 l2) {
        ListNode_21 first;
        ListNode_21 result = new ListNode_21(-1);
        first = result;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                result.next = new ListNode_21(l1.val);
                l1 = l1.next;
            }
            else {
                result.next = new ListNode_21(l2.val);
                l2 = l2.next;
            }
            result = result.next;
        }
        if (l1 != null) {
            result.next = l1;
            result = result.next;
        }
        if (l2 != null) {
            result.next = l2;
            result = result.next;
        }
        return first.next;
    }
}

public class LeetCode_21_MergeTwoSortedLinkedLists {

    public static void main(String[] args) {
        ListNode_21 l3 = new ListNode_21(4);
        l3.next = null;
        ListNode_21 temp = new ListNode_21(2);
        temp.next = l3;
        ListNode_21 l1 = new ListNode_21(1);
        l1.next = temp;

        ListNode_21 l4 = new ListNode_21(4);
        l4.next = null;
        ListNode_21 temp2 = new ListNode_21(3);
        temp2.next = l4;
//        ListNode_21 l2 = new ListNode_21(1);
//        l2.next = temp2;
        ListNode_21 result = new Solution_21().mergeTwoLists(null, null);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
        System.out.println();
    }

}
