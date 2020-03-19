package com.company.simple;

import com.company.simple.datastruct.ListNode;

/**
 * @description: 二进制链表转整数
 * @author: 15262
 * @date: 2020/3/19
 */

class LeetCode_1290_Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;
        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }
        return num;
    }
}

public class LeetCode_1290_ConvertBinaryNumberLinkedList2Integer {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, new ListNode(1, new ListNode(0)));
        LeetCode_1290_Solution solution = new LeetCode_1290_Solution();
        System.out.println(solution.getDecimalValue(listNode));
    }

}
