package com.company.simple;

import com.company.simple.datastruct.ListNode;

import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class LeetCode_445_Solution {

    /**
     * 6ms 代码更简洁明了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbersSweet(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 6 ms
     * , 在所有 Java 提交中击败了
     * 42.06%
     * 的用户
     * 内存消耗 :
     * 39.8 MB
     * , 在所有 Java 提交中击败了
     * 95.83%
     * 的用户
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 初始化l1的栈
        Stack<Integer> s1 = list2Stack(l1);
        Stack<Integer> s2 = list2Stack(l2);
        // 栈顶的位子都是统一位的数字
        Stack<Integer> res = new Stack<>();

        int carry = 0;
        while (!s1.isEmpty() && !s2.isEmpty()) {
            int sum = s1.pop() + s2.pop() + carry;
            carry = getCarry(res, sum);
        }

        carry = inputList2Stack(s1, res, carry);
        carry = inputList2Stack(s2, res, carry);

        if (carry != 0) {
            res.push(carry);
        }

        ListNode resList = null;
        ListNode first = null;
        while (!res.isEmpty()) {
            Integer val = res.pop();
            if (resList == null) {
                resList = new ListNode(val);
                first = resList;
            } else {
                resList.next = new ListNode(val);
                resList = resList.next;
            }
        }

        return first;
    }

    private int inputList2Stack(Stack<Integer> s1, Stack<Integer> res, int carry) {
        while (!s1.isEmpty()) {
            int sum = s1.pop() + carry;
            carry = getCarry(res, sum);
        }
        return carry;
    }

    private int getCarry(Stack<Integer> res, int sum) {
        int carry = 0;
        if (sum > 9) {
            carry = sum / 10;
            sum %= 10;
        }
        res.push(sum);
        return carry;
    }

    private Stack<Integer> list2Stack(ListNode l1) {
        Stack<Integer> stack = new Stack<>();
        ListNode tmpL1 = l1;
        while (tmpL1 != null) {
            stack.push(tmpL1.val);
            tmpL1 = tmpL1.next;
        }
        return stack;
    }

}

public class LeetCode_445_AddTwoNumbersII {

    public static void main(String[] args) {
        LeetCode_445_Solution solution = new LeetCode_445_Solution();
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l3 = new ListNode(1);
        ListNode l4 = new ListNode(9);

        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(8, new ListNode(9, new ListNode(9)));
        ListNode listNode = solution.addTwoNumbers(l5, l6);
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
        System.out.println();
    }

}
