package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * 两数相加
 */

class LeetCode_2_Solution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        int t = 0;
        while (l1 != null || l2 != null || t != 0) {
            if (l1 != null) {
                t += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                t += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(t % 10);
            pre = pre.next;
            t /= 10;
        }

        return dummyHead.next;
    }

}

public class LeetCode_2_AddTwoNumbers {

    public static void main(String[] args) {
        LeetCode_2_Solution solution = new LeetCode_2_Solution();
        ListNode list = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode list1 = new ListNode(5, new ListNode(6, new ListNode(4)));
        ListNode list2 = new ListNode(9, new ListNode(9));
        ListNode list3 = new ListNode(1);
        ListNode list4 = new ListNode(9);
        ListNode list5 = new ListNode(9);
        ListNode res = solution.addTwoNumbers(list4, list5);
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }

}
