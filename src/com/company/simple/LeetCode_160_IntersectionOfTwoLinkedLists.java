package com.company.simple;

import com.company.simple.datastruct.ListNode;

class LeetCode_160_Solution {

    /**
     * 思路：遍历a链，并在a链的每个节点之后插入一个自定义值的节点，直到a链结尾。之后遍历b，如果b节点中的某个节点的下一个节点是插入的特定节点，则返回该节点。否则返回null。
     * 错误：判断机制会察觉该链表已被修改，返回报错
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNodeError(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode tmp = headA;

        do {
            ListNode next = tmp.next;
            tmp.next = new ListNode(Integer.MIN_VALUE, null);
            tmp.next.next = next;
            tmp = next;
        } while (tmp.next != null);

        while (headB.next.val != Integer.MIN_VALUE) {
            headB = headB.next;
        }

        tmp = headB;

        while (tmp.next != null) {
            if (tmp.next.val == Integer.MIN_VALUE) {
                tmp.next = tmp.next.next;
            }
            tmp = tmp.next;
        }

        return headB;
    }

    /**
     * 思路：双指针法，两个指针同时从a，b链表头开始遍历，遍历完之后就从另一个链表的head开始遍历，如果两个节点有相同子集，两个节点就会撞在同一个节点，如果没有相交，则两个节点都会为null
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode la = headA;
        ListNode lb = headB;

        while (la != lb) {
            la = (la == null? headB : la.next);
            lb = (lb == null ? headA : lb.next);
        }

        return la;
    }
}

public class LeetCode_160_IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(8, new ListNode(4, new ListNode(5, null)));
        ListNode headA = new ListNode(4, new ListNode(1, listNode));
        ListNode headB = new ListNode(5, new ListNode(0, new ListNode(1, listNode)));

        LeetCode_160_Solution sol = new LeetCode_160_Solution();
        System.out.println(sol.getIntersectionNode(headA, headB));
    }

}
