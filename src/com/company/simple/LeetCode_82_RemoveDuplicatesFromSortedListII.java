package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 删除链表中的重复元素
 * @author: 15262  17:11 18:43 19:48 20:34
 * @date: 2020/3/11
 */
class LeetCode_82_Solution {
    public ListNode deleteDuplicates(ListNode head) {
        int count = 1;
        ListNode first = new ListNode(0);
        ListNode tmp = first;
        while (head != null) {
            ListNode next = head.next;

            if (count > 0 && next == null || (count > 0 && head.val != next.val)) {
                first.next = new ListNode(head.val);
                first = first.next;
            }
            while (next != null && next.val == head.val) {
                next = next.next;
            }
            // 拿到与链表头不同的元素，判断该元素与下一个元素是否相同，如果不相同则加入first
            if ((next != null && next.next != null && next.val != next.next.val) || (next != null && next.next == null)) {
                first.next = new ListNode(next.val);
                first = first.next;
            }
            // 结尾判断
            count--;
            head = next;

        }

        return tmp.next;
    }
}

public class LeetCode_82_RemoveDuplicatesFromSortedListII {

    public static void main(String[] args) {
        LeetCode_82_Solution solution = new LeetCode_82_Solution();
//        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
//        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
//        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(1)));
//        ListNode listNode = new ListNode(1, null);
        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        listNode = solution.deleteDuplicates(listNode);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
