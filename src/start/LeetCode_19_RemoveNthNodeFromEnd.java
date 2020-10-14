package start;

import start.struct.ListNode;

class LeetCode_19_RemoveNthNodeFromEndSolution {

    /**
     * 删除链表的倒数第n个节点
     *
     * @param head 链表头节点
     * @param n    要删除的节点位置
     * @return head 删除之后的链表头节点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        int lenth = calcListLen(head);

        return removeNth(head, lenth );
    }

    private ListNode removeNth(ListNode head, int n) {
        if (n == 1) {
            return head.next;
        }

        ListNode first, pre;
        first = pre = head;
        while (first != null) {
            n--;
            if (n == 0) {
                pre.next = first.next;
                break;
            }
            pre = first;
            first = first.next;
        }
        return head;
    }

    private int calcListLen(ListNode head) {
        int cnt = 0;
        ListNode node = head;
        while (node != null) {
            cnt++;
            node = node.next;
        }

        return cnt;
    }

}

public class LeetCode_19_RemoveNthNodeFromEnd {

    public static void main(String[] args) {

    }

}
