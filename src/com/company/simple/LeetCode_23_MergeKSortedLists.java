package com.company.simple;

import com.company.simple.datastruct.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

class LeetCode_23_Solution {

    ListNode merge(ListNode[] lists,int low,int high){
        if(low == high){
            return lists[low];
        }
        int mid=(low+high)/2;
        ListNode left=merge(lists,low,mid);
        ListNode right=merge(lists,mid+1,high);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        ListNode res=null;
        ListNode ptr=null;

        while(left!=null && right!=null){
            if(left.val > right.val){
                if(res==null){
                    res=right;
                    ptr=right;
                }
                else{
                    ptr.next=right;
                    ptr=ptr.next;
                }
                right=right.next;
            }
            else{
                if(res==null){
                    res=left;
                    ptr=left;
                }
                else{
                    ptr.next=left;
                    ptr=ptr.next;
                }
                left=left.next;
            }
        }

        if(left == null){
            ptr.next=right;
        }
        if(right == null){
            ptr.next=left;
        }
        return res;
    }

    public ListNode mergeKLists1ms(ListNode[] lists) {
        int length=lists.length;
        if(length <=0){
            return null;
        }
        return merge(lists,0,length-1);
    }

    public ListNode mergeKListByQueue(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode root = new ListNode(-1);
        merge(root, lists);
        return root.next;
    }

    private void merge(ListNode root, ListNode[] lists) {
        int used = 0;
        while (used < lists.length) {
            used = 0;
            int minIndex = 0;
            while (minIndex < lists.length && lists[minIndex] == null) {
                minIndex++;
            }
            for (int i = 0; i < lists.length; i++) {
                ListNode head = lists[i];
                if (head == null) {
                    used++;
                    continue;
                }
                if (minIndex < lists.length && lists[minIndex] != null && head.val < lists[minIndex].val) {
                    minIndex = i;
                }
            }
            if (minIndex < lists.length) {
                root.next = lists[minIndex];
                root = root.next;
                lists[minIndex] = lists[minIndex].next;
            }
        }
    }

}

public class LeetCode_23_MergeKSortedLists {

    public static void main(String[] args) {
        ListNode root2 = new ListNode(-1, new ListNode(5, new ListNode(11)));
        ListNode root3 = new ListNode(6, new ListNode(10));

        ListNode[] data = new ListNode[]{null, root2, null, root3};
        LeetCode_23_Solution solution = new LeetCode_23_Solution();
        ListNode listNode = solution.mergeKLists(data);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }

}
