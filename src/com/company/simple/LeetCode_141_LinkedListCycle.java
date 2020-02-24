package com.company.simple;

import com.company.simple.datastruct.ListNode;

import java.util.ArrayList;
import java.util.List;

class LeetCode_141_Solution {
    public boolean hasCycle1(ListNode head) {
        if (head == null || head.getNext() == null) return false;

        ListNode tmpNode = head;

        List<ListNode> cacheList = new ArrayList<>();
        while (tmpNode != null && !cacheList.contains(tmpNode)) {
            cacheList.add(tmpNode);
            tmpNode = tmpNode.getNext();
        }

        if (tmpNode == null) return false;
        return true;

    }

    public boolean hasCycle2(ListNode head) {
        while (head != null) {
            if (head.getVal() != Integer.MIN_VALUE) {
                head.setVal(Integer.MIN_VALUE);
            } else {
                return true;
            }
            head = head.getNext();
        }
        return false;
    }

    public boolean hasCycle3(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (!fast.equals(slow) && (slow != null || fast.getNext() != null)) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return !(slow == null || fast.getNext() == null);
    }
}

public class LeetCode_141_LinkedListCycle {

    public static void main(String[] args) {
        LeetCode_141_Solution solution = new LeetCode_141_Solution();

        ListNode circleNode = new ListNode(2, new ListNode(0, null));
        ListNode endNode = new ListNode(4, circleNode);
        circleNode.getNext().setNext(endNode);
        ListNode head = new ListNode(3, circleNode);
        assert solution.hasCycle3(head);
    }

}
