package start;

import start.struct.ListNode;

import java.util.LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class LeetCode_234_PalindromeLinkedListSolution {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        LinkedList<String> deque = new LinkedList<>();
        ListNode node = head;
        while (node != null) {
            deque.addLast(node.val+"");
            node = node.next;
        }

        while (deque.size() >= 1) {
            if (deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }
        return true;
    }

}

public class LeetCode_234_PalindromeLinkedList {
}
