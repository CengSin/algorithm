package start;

import start.struct.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // L0->L1->...->Ln-1->Ln 变为 L0->Ln->L1->Ln-1->L2->Ln-2->...
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }

        // 把链表放入数组
        List<ListNode> arr = new ArrayList<>();

        ListNode node = head;

        while (node != null) {
            arr.add(node);
            node = node.next;
        }

        int left = 0;
        int right = arr.size() - 1;

        // 通过数组遍历来进行转换
        while (left < right) {
            arr.get(left).next = arr.get(right);
            arr.get(right--).next = arr.get(++left);
        }

        arr.get(left).next = null;
    }

}

public class LeetCode_143_ReorderList {
}
