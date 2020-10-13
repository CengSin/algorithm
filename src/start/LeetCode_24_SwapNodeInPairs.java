package start;

import start.struct.ListNode;

class LeetCode_24_SwapNodeInPairs_Solution {

    public ListNode swapPairs(ListNode head) {
        ListNode first = new ListNode(0);
        first.next = head;
        swap(first, head);
        return first.next;
    }

    private void swap(ListNode pre, ListNode cur) {
        if (cur == null || cur.next == null) {
            return ;
        }

        ListNode nx = cur.next;
        pre.next = nx;
        cur.next = nx.next;
        nx.next = cur;

        swap(cur, cur.next);
    }
}

public class LeetCode_24_SwapNodeInPairs {
}
