package start;


import start.struct.ListNode;

import java.util.HashSet;

class LeetCode_142_Solution_WSCN {

    public ListNode detectCycle(ListNode head) {

        if (head == null) {
            return null;
        }
        // return setCheckDupEle(head);
        return fastSlowPointCheck(head);
    }

    private ListNode fastSlowPointCheck(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null) {
            if (fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast.equals(slow)) {
                ListNode ptr = head;

                while (!ptr.equals(slow)) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }

        return null;
    }

    private ListNode setCheckDupEle(ListNode head) {
        HashSet<ListNode> visit = new HashSet<>();
        while (head != null) {
            if (visit.contains(head)) {
                return head;
            }
            visit.add(head);
            head = head.next;
        }
        return null;
    }

}

public class LeetCode_142_LoopLinkedLIstII {


}
